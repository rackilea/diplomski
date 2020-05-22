FullTextSession fullTextSession = Search.getFullTextSession(session);
fullTextSession.createIndexer(Company_Info.class).startAndWait();

QueryBuilder qb = fullTextSession.getSearchFactory()
    .buildQueryBuilder().forEntity(Company.class).get();
org.apache.lucene.search.Query query = qb.keyword()
        .onFields("company_name","locations.city")
        .matching(keyword)
    .createQuery();

org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, Company_Info.class);

List<Company_Info> result = hibQuery.list();