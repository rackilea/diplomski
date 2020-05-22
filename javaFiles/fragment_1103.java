public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the code you want to check: ");
    String input = scan.next();

    List<String> codes = new ArrayList<>();
    codes.add("ABC(Q,E,1)EEE");
    codes.add("ABDCE(E,Z,X)E");
    codes.add("B(A,1)AAEEE");
    codes.add("R(1,2,3,4,5)RT(U,M,N,B,V,H)(Q,E,R,F,G,H)(R,Z)");
    codes.add("B(A,1)AA(E,Z)EE");

    //list to store the modified strings
    List<String> modifiedCodes = new ArrayList<>();
    //for each string in list find if there is a pattern like '('some chars')'
    Pattern p = Pattern.compile("\\(.*\\)");
    for (Iterator<String> i = codes.iterator(); i.hasNext();) {
        String code = i.next();
        StringBuffer  sb = new StringBuffer ();
        Matcher m = p.matcher(code);
         while (m.find()) { 
            String match = m.group();
            //if found a match replace '(' and ')' with '[' and ']' and remove commas
            m.appendReplacement(sb, match.replace('(', '[').replace(')', ']').replace(",", ""));
          }
          m.appendTail(sb);
          //add modified string to list
          modifiedCodes.add(sb.toString());
    }     

    boolean codeIsPresent = false;
    for(String code: modifiedCodes){
        //check if input matches one of the regex in the list 'modifiedCodes'
        if (input.matches(code)) {
            codeIsPresent = true;
            System.out.println("True: This code is present");
            break;
        }
    }
    if(!codeIsPresent){
        System.out.println("Code not found");
    }
}