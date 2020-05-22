public static void main(String[] args) throws Exception {
    String target = "Thu Sep 28 20:29:30 JST 2000";
    DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
    Date result =  df.parse(target);  
    System.out.println(result);
}