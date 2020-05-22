FullTextSession fullTextSession = Search.getFullTextSession(session);
    fullTextSession.createIndexer().startAndWait();
    QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(JobSeeker.class).get();
    Query query = null;
    for (String string : skills) {
        query = qb.keyword().onField("skills.skillIdPk").matching(Integer.parseInt(string)).createQuery();
    }
    org.hibernate.search.FullTextQuery query1 =
            fullTextSession.createFullTextQuery(query, JobSeeker.class);
        query1.setProjection("jobSeeker.jobSeekerId", "skills.skill");
        List results = query1.list();
        for (int i = 0; i < results.size(); i++) {
            Object[] object = (Object[]) results.get(i);
            System.out.println(object[0]);
            System.out.println(object[1]);
        }
    //  List<Skills> authorName1 = (List<Skills>) firstResult[1];
    //  System.out.println(authorName1);
    return results;