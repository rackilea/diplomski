@PersistenceContext
private EntityManager em;
@Override
public Collection<WorkOrderDTO> getWork() {
    Query query = em.createNativeQuery(
              "SELECT Sub1.wo_number, Sub2.service_types, Sub1.order_title FROM (SELECT * FROM workorder) Sub1 INNER JOIN (SELECT wo_number, GROUP_CONCAT(service_type SEPARATOR ', ') AS 'service_types' FROM service_type GROUP BY wo_number) Sub2 ON Sub1.wo_number=Sub2.wo_number WHERE fleet_company_id=4 AND (order_status='On-Bidding' OR order_status='Draft')", "workorder");
    @SuppressWarnings("unchecked")
    Collection<WorkOrderDTO> dto = query.getResultList();

    Iterable<WorkOrderDTO> itr = dto;
    return (Collection<WorkOrderDTO>)itr;
}