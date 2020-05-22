fullTextQuery = queryBuilder
                .simpleQueryString()
                .onFields("firstName", "lastName", "extraName", "biography")
                .withAndAsDefaultOperator()
                .matching(criteria)
                .createQuery();