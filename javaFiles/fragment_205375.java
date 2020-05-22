public static void main(String[] args){
    String expression = "a b c d e";
    StringTokenizer sTokenizer  = new StringTokenizer(expression);
    System.out.println(sTokenizer.nextToken());
    System.out.println(sTokenizer.nextToken(""));
}