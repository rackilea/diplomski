Root<Update> fromUpdates = query.from(Update.class);
Join<Update, Detail> details = fromUpdates.join("details");
Join<Detail, Associate> associate = details.join("associate");
List<Predicate> conditions = new ArrayList();
conditions.add(builder.equal(associate.get("associateId"), associateId));
conditions.add(builder.isNull(details.get("ack_date")));

TypedQuery<Update> typedQuery = em.createQuery(query
        .select(fromUpdates)
        .where(conditions.toArray(new Predicate[] {}))
        .orderBy(builder.asc(fromUpdates.get("updateId")))
        .distinct(true)
);