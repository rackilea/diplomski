public static boolean isBalanced(String s, int i, Stack<Character> expected) {
    /* end has reached and not expecting anything then break */
    if (i == s.length())
        return expected.isEmpty();

    char c = s.charAt(i);
    /* expecting something and it is a closing type */
    /* then it should match expecting type */
    if (c == '}' || c == ')' || c == ']') {
        char e = expected.isEmpty() ? '\0' : expected.pop();
        if(e != c)
            return false;
    }

    if(c == '{') 
        expected.push('}');
    else if(c == '[')
        expected.push(']');
    else if(c == '(')
        expected.push(')');

    /* call recursively with i + 1 */ 
    return isBalanced(s, i + 1, expected);

}