List<Movie> movies = entityManager
            .createNamedQuery("Movie.byCelebrity")
            .setParameter("role", role)
            .unwrap(org.hibernate.query.Query.class)
            .setResultTransformer(new MovieResultTransformer())
            .getResultList();