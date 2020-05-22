public static void main(String args[]){
    //change your input to a regular expression
    //"BA(1,2,3)QW(A-Z,0-9)"  to  "BA[1-3]QW[A-Z][0-9]"
    Generex generex = new Generex("BA[1-3]QW[A-Z][0-9]");
    List<String> matchedStrs = generex.getAllMatchedStrings();
    matchedStrs.forEach(System.out::println);
}