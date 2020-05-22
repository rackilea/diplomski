for (Field field: whereClause.getAnd()) {

      if(field.getOperator().equalsIgnoreCase(QueryOperator.IS))
      {
          andCriterias.add(Criteria.where(field.getFieldName()).is(field.getFieldValue()));

      } else {
          andCriterias.add(Criteria.where(field.getOperator()).is(new BasicDBObject(field.getFieldName(), field.getFieldValue())));
      }
  }