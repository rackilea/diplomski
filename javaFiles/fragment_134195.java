public String getVal(String[] atrArray, String attrName){
    // Return a Null string ("") if the supplied Array
    // contains nothing or the attrName parameter 
    // contains Null or Null String.
    if (atrArray.length == 0 || attrName == null || attrName.isEmpty()) { 
        return ""; 
    }
    String returnString = ""; 
    String str = "";
    for(int i = 0; i < atrArray.length; i++) {
        str = atrArray[i]; 
        if(str.contains(attrName)){
            if (returnString.equals("")) {
                returnString+= str;
            }
            else {
                // Delimit any addition elements with
                // a semicolon.
                returnString+= ";" + str;
            }
        }
    }
    return returnString;
}