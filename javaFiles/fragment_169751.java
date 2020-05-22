Collections.sort(resultList, new Comparator<Object[]>() {
     public int compare(Object[] array, Object[] otherArray) {

     //do the Date comparison by casting Object to Date
     int dateComparison = (((Date)array[4]).compareTo((Date)otherArray[4]));

      //Now, do the String comparison by casting Object to String
     return dateComparison == 0 ? 
             ((String)array[3]).compareTo((String)otherArray[3]) : dateComparison;
      }
 });