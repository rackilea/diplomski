EntityManager em = emf.createEntityManager();

    // [UPDATED] QUERY
    String jpql = "SELECT p.id, pd.description FROM Product p "
                + "JOIN p.productDescriptions pd "
                + "JOIN pd.language l WHERE l.language_id = :idLanguage)";

    Query query = newEm.createQuery(jpql);
    query.setParameter("idLanguage", new Long(1));

    List<Object> resultList = query.getResultList();

    System.out.println( resultList.size() + " product(s) found:" );

    for (Object singleResult : resultList) {
         Object[] singleRow = (Object[]) singleResult;
         System.out.println(singleRow[0] + " " + singleRow[1]);
    }