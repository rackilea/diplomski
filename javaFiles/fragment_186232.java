static boolean checkParentheses(String s) {
    // capture a text starting with one opening parenthesis, 
    // ending with one closing and having no parentheses inside
    Pattern p = Pattern.compile("\\([^()]*\\)");  
    Matcher m;
    while ((m = p.matcher(s)).find())
       s = m.replaceAll("");
    return !(s.contains("(") || s.contains(")"));
}