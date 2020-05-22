public static void main(String[] args) {

    Matcher m = Pattern.compile("a").matcher("abababababababab");

    StringBuffer sb = new StringBuffer();
    int i = 1;
    while (m.find()) 
        m.appendReplacement(sb, new DecimalFormat("000").format(i++));
    m.appendTail(sb);        

    System.out.println(sb);
}