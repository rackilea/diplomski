static <T> List<T> findRowByColumnValue(List<T> array, String column, Object compareValue){
    List<T> hits= new ArrayList<T>();
    for (T element : array) {
        if (element != null && compareValue.equals(
          element.getClass().getField(column).get(element)) 
            hits.add(element);
    }
    return hits;
}