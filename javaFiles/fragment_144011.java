// added
    Query query = new Query();

    if(null != eventSearch.getQuery())
    {

        if(null != eventSearch.getQuery().getWhere() && eventSearch.getQuery().getWhere().size() > 0)
        {
            // added
            List<Criteria> wheres = new ArrayList<>();

            for (Where whereClause : eventSearch.getQuery().getWhere()) {

                // added
                Criteria where = new Criteria();

                  if(null != whereClause.getOr() && whereClause.getOr().size() > 0){

                      List<Criteria> orCriterias = new ArrayList<Criteria>(whereClause.getOr().size());

                      for (Field field: whereClause.getOr()) {

                          if(field.getOperator().equalsIgnoreCase(QueryOperator.IS))
                          {
                            orCriterias.add(Criteria.where(field.getFieldName()).is(field.getFieldValue()));

                          }else if(field.getOperator().equalsIgnoreCase(QueryOperator.LT)){

                            orCriterias.add(Criteria.where(field.getFieldName()).lt(field.getFieldValue()));
                          } 
                          else if(field.getOperator().equalsIgnoreCase(QueryOperator.GT)){

                              orCriterias.add(Criteria.where(field.getFieldName()).gt(field.getFieldValue()));
                          } 
                          else if(field.getOperator().equalsIgnoreCase(QueryOperator.LTE)){

                              orCriterias.add(Criteria.where(field.getFieldName()).lte(field.getFieldValue()));
                           }
                          else if(field.getOperator().equalsIgnoreCase(QueryOperator.GTE)){

                              orCriterias.add(Criteria.where(field.getFieldName()).gte(field.getFieldValue()));
                           }
                      } 

                      // comment out
                      // query.addCriteria(new Criteria().orOperator(orCriterias.toArray(new Criteria[whereClause.getOr().size()])));

                      // replaced with
                      if (orCriterias.size() > 0) {
                          where.orOperator(orCriterias.toArray(new Criteria[0]));
                      }
                  }

                  if(null != whereClause.getAnd() && whereClause.getAnd().size() > 0){

                      List<Criteria> andCriterias = new ArrayList<Criteria>(whereClause.getAnd().size());

                      for (Field field: whereClause.getAnd()) {

                          if(field.getOperator().equalsIgnoreCase(QueryOperator.IS))
                          {
                              andCriterias.add(Criteria.where(field.getFieldName()).is(field.getFieldValue()));

                          }else if(field.getOperator().equalsIgnoreCase(QueryOperator.LT)){

                              andCriterias.add(Criteria.where(field.getFieldName()).lt(field.getFieldValue()));
                          } 
                          else if(field.getOperator().equalsIgnoreCase(QueryOperator.GT)){

                              andCriterias.add(Criteria.where(field.getFieldName()).gt(field.getFieldValue()));
                          } 
                          else if(field.getOperator().equalsIgnoreCase(QueryOperator.LTE)){

                              andCriterias.add(Criteria.where(field.getFieldName()).lte(field.getFieldValue()));
                           }
                          else if(field.getOperator().equalsIgnoreCase(QueryOperator.GTE)){

                              andCriterias.add(Criteria.where(field.getFieldName()).gte(field.getFieldValue()));
                           }
                      } 

                      // comment out
                      // //Getting exception at this line
                      // query.addCriteria(new Criteria().andOperator(andCriterias.toArray(new Criteria[whereClause.getAnd().size()])));

                      // replaced with
                      if (andCriterias.size() > 0) {
                          where.andOperator(andCriterias.toArray(new Criteria[0]));
                      }

                  }

                  // added
                  wheres.add(where);
                }
                // added
                if (wheres.size() > 0) {
                    query.addCriteria(new Criteria().andOperator(wheres.toArray(new Criteria[0])));
                }
            }
    }