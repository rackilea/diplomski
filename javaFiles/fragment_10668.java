private static void patternMatch() throws NomatchException{

    final Pattern p = Pattern.compile("ab");
    final Matcher m = p.matcher(str);

    if(m.find()){
        System.out.print(m.group());
    } else{
        throw new NomatchException("no match");
    }

}