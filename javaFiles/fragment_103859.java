/**
 * Retrieves all sub-strings on either side of the supplied open brace and close brace. 
 * Everything within braces (including the braces) is excluded.<br>
 * 
 * @param inputString (String) The string to process. if Null or Null String is 
 * supplied then this method will throw a IllegalArgumentException exception.<br><br>
 * 
 * @param openBrace (String) The Open Brace of which to ignore content within. 
 * This can be Parentheses ( ( ), Square Brackets ( [ ), Curly Braces ( { ), or 
 * Chevron Brackets ( &lt; ). if Null or Null String is supplied then this method 
 * will throw a IllegalArgumentException exception.<br>
 * 
 * @param closeBrace (String) The Close Brace of which to ignore content within. 
 * This can be Parentheses ( ) ), Square Brackets ( ] ), Curly Braces ( } ), or 
 * Chevron Brackets ( &gt; ). if Null or Null String is supplied then this method 
 * will throw a IllegalArgumentException exception.<br>
 * 
 * @param trimElements (Optional - Boolean - Default is false) If this optional
 * parameter is set to boolean true then the returned array elements will have
 * any leading or trailing white-spaces removed.<br>
 * 
 * @return (Single Dimensional String Array) The detected sub-strings within a 
 * 1D String Array.
 */
public String[] getSubstringsOutsideBraces(String inputString, String openBrace, 
        String closeBrace, boolean... trimElements) {
    if (inputString == null || inputString.equals("") || 
        openBrace == null || openBrace.equals("") || 
        closeBrace == null || closeBrace.equals("")) {
        throw new IllegalArgumentException("\ngetSubstringsOutsideBraces() Method Error! "
                + "A method argument contains Null or Null String!\n");
    }
    boolean trim = false;
    if (trimElements.length > 0) { 
        trim = trimElements[0]; 
    }
    String[] array = inputString.split(
        // Using Ternary Operator so as to apply an additional 
        // RegEx to the split() method in order to remove the 
        // need for IF/ELSE and a FOR loop to trim elements if
        // desired to do so.
       (trim) ? "\\s*\\" + openBrace + ".*?\\" + closeBrace + 
             "\\s*" : "\\" + openBrace + ".*?\\" + closeBrace
    );
    return array;
}