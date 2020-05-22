...
List<TopNValue> values = new ArrayList<>();
QueryContext queryContext = getQueryContext(entityType, property, propertyType, n, true);
try (IndexHits<Node> indexHits = nodeIndex.query(property, queryContext))
{
  for (Node node : indexHits)
  {
    values.add(node);
  }
}
...

private static QueryContext getQueryContext(String entityType, String property, String type, int n, boolean reversed)
{
  NumericRangeQuery propertyQuery;
  int fieldType;
  switch (type)
  {
    case GraphTypes.LONG:
      propertyQuery = NumericRangeQuery.newLongRange(property, Long.MIN_VALUE, Long.MAX_VALUE, true, true);
      fieldType = SortField.LONG;
      break;
    case GraphTypes.DOUBLE:
      propertyQuery = NumericRangeQuery.newDoubleRange(property, Double.MIN_VALUE, Double.MAX_VALUE, true, true);
      fieldType = SortField.DOUBLE;
      break;
    case GraphTypes.FLOAT:
      propertyQuery = NumericRangeQuery.newFloatRange(property, Float.MIN_VALUE, Float.MAX_VALUE, true, true);
      fieldType = SortField.FLOAT;
      break;
    case GraphTypes.INT:
      propertyQuery = NumericRangeQuery.newIntRange(property, Integer.MIN_VALUE, Integer.MAX_VALUE, true, true);
      fieldType = SortField.INT;
      break;
    default:
      throw new IllegalArgumentException("Cannot create NumericRangeQuery for type: " + type);
  }
  Query query;
  if (entityType == null)
  {
    query = propertyQuery;
  }
  else
  {
    TermQuery entityTypeQuery = new TermQuery(new Term("EntityType", entityType));
    BooleanQuery booleanQuery = new BooleanQuery();
    booleanQuery.add(entityTypeQuery, BooleanClause.Occur.MUST);
    booleanQuery.add(propertyQuery, BooleanClause.Occur.MUST);
    query = booleanQuery;
  }
  Sort sorting = new Sort(new SortField(property, fieldType, reversed));
  return new QueryContext(query).sort(sorting).top(n);
}