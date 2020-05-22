@Service
public class UtilRespository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public int removeCouponOwnership(Coupon coupon) {
        String query = "DELETE FROM customer_coupon WHERE coupon_id = ";
        query += coupon.getId();

        Query q = em.createNativeQuery(query);
        int removed = q.executeUpdate();
        em.close();
        System.out.println("Successfully removed Coupon " + coupon.getId() + " from " + removed + " customers;");
        return removed;
    }
}