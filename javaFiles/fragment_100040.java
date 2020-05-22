/**
 *criterias hold Map<FieldName,ExpectedValue>
 *
 */
boolean rowFitsTheCriteria(RowResult row,Map<String,String> criterias){
    boolean result = criterias.keySet().stream().allMatch(fieldName->row.get(fieldName).equals(criterias.get(fieldName)));
    return result;
}