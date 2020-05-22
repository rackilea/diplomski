private String getValue(String valueOne, String valueTwo) 
{
      if(isNullOrEmpty(valueOne) && isNullOrEmpty(valueTwo))
      {
         return "";
      }
      else if (isNullOrEmpty(valueOne))
      {
        return valueTwo;
      }
      else if (isNullOrEmpty(valueTwo))
      {
       return valueOne;
      }

    return valueOne.concat("-").concat(valueTwo);    
}

 private boolean isNullOrEmpty(String str)
 {
    return str == null || str.isEmpty();
 }