public static void main(String[] args) {
   String text = "(1,'Ctx_Log-Log','','08.03.2017','2017-03-08 10:59:31','10:59:32','2017-03-08 10:59:41')";
   String regex = "'[0-9]{4}-[0-9]{2}-[0-9]{2}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}'";
   String template = "TO_TIMESTAMP(%s,'YYYY-MM-DD HH24:MI:SS')";

   Matcher matcher = Pattern.compile(regex).matcher(text);

   while (matcher.find()) {
       String value = matcher.group();
       text = text.replace(value, String.format(template, value));
   }

   System.out.println(text);
}