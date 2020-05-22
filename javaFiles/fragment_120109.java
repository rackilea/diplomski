public void buildSymbols() {
    String s = expr; // input from different part of the program 
    StringTokenizer st = new StringTokenizer(s, "+-*/[]() ", true);
    Set<String> delimiters=new HashSet<String>(Arrays.asList(new String[]{"+","-","*","/","[","]","(",")"," "}));
    List<Object> tokens=Collections.list(st);
    for(int i=0;i<tokens.size();i++){
        String temp = tokens.get(i).toString();
        if (delimiters.contains(temp))
        {
            // It is a delimiter
        }
        else
        {
            // It is a term
            boolean isAnArray=(isNextTokenAnOpenBracket(tokens, i));
            ...
        }
        System.out.println(temp);
    }
}

private boolean isNextTokenAnOpenBracket(List<Object> tokens, int currentIndex)
{
    return (currentIndex < tokens.size() && "[".equals(tokens.get(1 + currentIndex)));
}