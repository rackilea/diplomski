QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(Movie.class).get();
        org.apache.lucene.search.Query query = qb
                .keyword().wildcard().onFields("year", "title")
                .matching(searchText + "*")
                .createQuery();