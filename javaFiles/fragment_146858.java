public List<InfluenceDetails> getDetailsByAggregator(String aggKey,
                                                     String aggValue) {
    FluentQuery query = FluentJPA.SQL((InfluenceDetails details) -> {

        QualityAggregator relevantAgg = subQuery((QualityAggregator it,
                                                  QualityAggregator agg,
                                                  QualityAggregator child) -> {
            SELECT(agg);
            FROM(agg);
            WHERE(agg.getAggKey() == aggKey && agg.getAggValue() == aggValue);

            UNION_ALL();

            SELECT(child);
            FROM(child).JOIN(recurseOn(it)).ON(child.getParent() == it);
        });

        WITH(RECURSIVE(relevantAgg));

        // DISTINCT removes possible dups
        SELECT(DISTINCT(details));
        FROM(details).JOIN(relevantAgg).ON(details.getAggregators() == relevantAgg);
    });

    return query.createQuery(em, InfluenceDetails.class).getResultList();
}