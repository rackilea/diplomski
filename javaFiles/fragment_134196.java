public String[] getVal(String[] atrArray, String attrName){
    // Return Null if the supplied Array contains 
    // nothing or the attrName parameter contains 
    // Null or Null String.
    if (atrArray.length == 0 || attrName == null || attrName.isEmpty()) { 
        return null; 
    }

    String[] returnArray = {};
    String wrkString = ""; 
    String str = "";
    for(int i = 0; i < atrArray.length; i++) {
        str = atrArray[i]; 
        if(str.contains(attrName)){
            if (wrkString.equals("")) {
                wrkString+= str;
            }
            else {
                // Delimit any additional elements with
                // something obscure like the Pipe (|) 
                // character since some elements might
                // contain data utilizing the usual
                // delimiters used.
                wrkString+= "|" + str;
            }
        }
    }
    // Now use the String.split() method to convert 
    // our Pipe delimited string to a String Array.
    if (!wrkString.equals("")) {
        returnArray = wrkString.split("\\|");
    }
    // Return our String Array
    return returnArray;
}