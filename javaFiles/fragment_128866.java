String HQL_QUERY = "select comp.id as comp_id, comp.name as comp_name from Company comp";
    Query query = session.createQuery(HQL_QUERY);
    query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

    List<?> rows = query.list();    
    System.out.println("Selected row count : " + rows.size());

    for (Object row : rows) {
      System.out.println(row); //Each row is a map of properties in the query
                   //with key as alias and property as value
    }