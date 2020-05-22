/**
 * Retrieves all sub-strings inside of the supplied open brace and close brace. 
 * Everything outside of braces (including the braces) is excluded.<br>
 * 
 * @param inputString (String) The string to process. if Null or Null String is 
 * supplied then this method will throw a IllegalArgumentException exception.<br>
 * 
 * @param openBrace (String) The Open Brace of which to get content within. 
 * This can be Parentheses ( ( ), Square Brackets ( [ ), Curly Braces ( { ), or 
 * Chevron Brackets ( &lt; ). if Null or Null String is supplied then this method 
 * will throw a IllegalArgumentException exception.<br>
 * 
 * @param closeBrace (String) The Close Brace of which to get content within. 
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
public String[] getSubstringsInsideBraces(String inputString, String openBrace, 
        String closeBrace, boolean... trimElements) {
    // Make sure all arguments are supplied...
    if (inputString == null || inputString.equals("") || 
        openBrace == null || openBrace.equals("") || 
        closeBrace == null || closeBrace.equals("")) {
        throw new IllegalArgumentException("\ngetSubstringsInsideBraces() Method Error! "
                + "A method argument contains Null or Null String!\n");
    }
    // See if the option to trim bracketed content is desired.
    boolean trim = false;
    if (trimElements.length > 0) { 
        trim = trimElements[0]; 
    }

    // Apply the Regular Expression to Pattern. The supplied 
    // open and close braces are used within the expression.
    Pattern regex = Pattern.compile("\\" + openBrace + "(.*?)\\" + closeBrace);
    // Run the pattern to see if there are any matches.
    Matcher matcher = regex.matcher(inputString);
    // Establish a String List Object to hold any matches.
    List<String> list = new ArrayList<>();

    // Retrieve any matches found and add to List.     
    while (matcher.find()) {
        // Using a ternary operator against whether or not to 
        // Trim the matched item if desired before adding it 
        // to the List. This saves on doing a IF/THEN/ELSE.
        list.add((trim) ? matcher.group(1).trim() : matcher.group(1));
    }

    // Convert the List to a 1D String Array
    if (list.isEmpty()) { return null; }
    String[] array = new String[list.size()];
    array = list.toArray(array);

    // Return the 1D String Array
    return array;
}