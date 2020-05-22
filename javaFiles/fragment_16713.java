if (criteria.getType().equals(SelectionDataType.INTEGER))
  {
    ArrayList<Integer> values = criteria.getValue();
    predicates.add(entityPath.get(criteria.getField()).in((values)));
  }
  else if (criteria.getType().equals((SelectionDataType.STRING)))
  {
     ArrayList<String> values = criteria.getValue();
    predicates.add(entityPath.get(criteria.getField()).in((evalues)));
  }