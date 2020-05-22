CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<StatisticsDate> cq = cb.createQuery(StatisticsDate.class);
Root<StatisticsDate> rootEntry = cq.from(StatisticsDate.class);
CriteriaQuery<StatisticsDate> all = cq.select(rootEntry).orderBy(cb.desc(
    cb.function(
        "to_timestamp", Timestamp.class,
        rootEntry.get("lastTimeExecutedDate"),
        cb.literal("DD.MM.YYYY:HH24:MI:SS")
    )
));

TypedQuery<StatisticsDate> allQuery = em.createQuery(all);