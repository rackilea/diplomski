public List<Product> search(String term) {
        EntityManager em = this.currentSession();

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);

        // create native Lucene query unsing the query DSL
        // alternatively you can write the Lucene query using the Lucene query parser
        // or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Product.class)
                .get();

        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .onFields("description",  "productName")
                .matching(term)
                .createQuery();

        // wrap Lucene query in a javax.persistence.Query
        javax.persistence.Query jpaQuery =
                fullTextEntityManager.createFullTextQuery(luceneQuery, Product.class);

        // execute search
        List<Product> result = jpaQuery.getResultList();

        return result;
    }