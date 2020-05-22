@Override
    public List<WorkerEntity> getWorkersByOffice(long officeId) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<WorkerEntity> query = cb.createQuery(WorkerEntity.class);

        Root<WorkerEntity> worker= query.from(WorkerEntity.class);
        OfficeEntity office  = new OfficeEntity();
        office.setId(officeId);
        query.select(worker).where(cb.equal(worker.get("office"),office));

        TypedQuery<OfficeEntity> typedQuery = entityManager.createQuery(query);
        List<WorkerEntity> workerList= typedQuery.getResultList();

        return workerList;

    }