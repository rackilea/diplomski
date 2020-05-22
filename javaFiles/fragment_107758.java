public Map<Integer, Warnings> load(
        int maxId, 
        LocalDateTime timestampStart,
        LocalDateTime timestampEnd) {
    return create
            .select(WARNINGS.fields())
            .select(WARNINGS_HISTORY.ID) // Add the ID to the SELECT list
            .from(WARNINGS_HISTORY)
            .innerJoin(WARNINGS).using(WARNINGS.SIDFILENAME)
            .where(WARNINGS_HISTORY.IID.greaterThan(maxId))
            .and(WARNINGS_HISTORY.DTCREATEDATE.greaterOrEqual(timestampStart))
            .and(WARNINGS_HISTORY.DTCREATEDATE.lessOrEqual(timestampEnd))
            .orderBy(WARNINGS_HISTORY.IID.asc())
            .fetchMap(

                // Mapping the Map key is straight forward
                r -> r.get(WARNINGS_HISTORY.ID),

                // Mapping the Map value needs an extra step to avoid the ambiguity
                // between WARNINGS.ID and WARNINGS_HISTORY.ID when you use into(Class),
                // i.e. when you use jOOQ's DefaultRecordMapper
                r -> r.into(WARNINGS).into(Warnings.class)
            );
}