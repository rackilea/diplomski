String rpnExp = "-4    3 + 5 * 3 - -61 *";
StringBuilder newToken = new StringBuilder();
List<String> tokens = new ArrayList<String>();

for ( char c : rpnExp.toCharArray() ) {
    // the current char is a space?
    if ( c == ' ' ) {
        // yes, it is.
        // the new token has something?
        if ( newToken.length() > 0 ) {
            // yes, it has
            // add its value to the token list
            tokens.add( newToken.toString() );
            // resets new token
            newToken = new StringBuilder();
        }
    } else {   // c is not a space
        // yes, so add it to the newToken
        newToken.append( c );
    }
}

// needs to process the last value of newToken
// so, if it has something
if ( newToken.length() > 0 ) {
    // add the value to the token list
    tokens.add( newToken.toString() );
}

Stack<Integer> stack = new Stack<Integer>();
// the rest of the code here ...