if (criteria.getType().equals(SelectionDataType.INTEGER))
  {
    predicates.add(entityPath.get(criteria.getField()).in((extractArrayListInteger(criteria))));
  }
  else if (criteria.getType().equals((SelectionDataType.STRING)))
  {
    predicates.add(entityPath.get(criteria.getField()).in((extractArrayListString(criteria))));
  }