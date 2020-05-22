public static void main(String[] args) { 
    System.out.println(mapNumbersToCharsAndConcat("ab1ab"));
    System.out.println(mapNumbersToCharsAndConcat("abcd00hdjhs1224"));
}
static String mapNumbersToCharsAndConcat (String input){
    char[] myChars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    StringBuilder sb = new StringBuilder();       
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(input);
    while(m.find()){
        String num = m.group();
        sb.append(myChars[modFromString(num)]);
    }
    return sb.toString();
}
static int modFromString(String num){
    int res = 0;   
    for (int i = 0; i < num.length(); i++){
        res = (res * 10 + (int)num.charAt(i) - '0') % 26; 
    }
    return res; 
}