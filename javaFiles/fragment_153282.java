// Convert list to array
String[] stringListAsArray = stringList.toArray(new String[] {});

// Copy
System.arraycopy(stringListAsArray, 0, 
                 stringArray, 0, stringListAsArray.length);