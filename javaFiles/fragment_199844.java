public static <T> T mapValueString(String valueString, Class<T> targetType) {

  if (valueString == null) {
     return null;
  }
  else if(targetType.equals(String.class)) {
     return (T)valueString;
  }
  else if (targetType.equals(Date.class)) {
     return (T)MyDateTime.parseDate(valueString);
  }
  else if (targetType.equals(Timestamp.class)) {
     return (T)MyDateTime.parseTimestamp(valueString);
  }
  else if (targetType.equals(Boolean.class)) {
     String upperVal = valueString.toUpperCase();
     if (upperVal.startsWith("T")) {
        return (T)Boolean.TRUE;
     }
     else if (upperVal.startsWith("F")) {
        return (T)Boolean.FALSE;
     }
     else {
        throw new RuntimeException("Failed to parse value string into Boolean object. String was " + valueString + ".");
     }
  }
  else if (targetType.equals(Integer.class)) {
     Integer i;
     try {
        i = Integer.parseInt(valueString);
     }
     catch (NumberFormatException nfe) {
        throw new RuntimeException("Failed to parse value string into Integer object. String was " + valueString + ".", nfe);
     }
     return (T)i;
  }
  else if (targetType.equals(Long.class)) {
    Long l;
    try {
       l = Long.parseLong(valueString);
    }
    catch (NumberFormatException nfe) {
       throw new RuntimeException("Failed to parse value string into Long object. String was " + valueString + ".", nfe);
    }
    return (T)l;
  }
  else if (targetType.equals(Double.class)) {
     Double d;
     try {
        d = Double.parseDouble(valueString);
     }
     catch (NumberFormatException nfe) {
        throw new RuntimeException("Failed to parse value string into Double object. String was " + valueString + ".", nfe);
     }
     return (T)d;
  }
  else {
     throw new RuntimeException("Unsupported java type " + targetType.getName() + ".");
  }
}