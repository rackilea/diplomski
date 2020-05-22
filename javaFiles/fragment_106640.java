URL url;
ArrayList<String> finalResult = new ArrayList<String>();

try {
    String content = null;
    URLConnection connection = null;
    try {
        connection = new URL("https://yahoo.com").openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        scanner.useDelimiter("\\Z");
        content = scanner.next();
        scanner.close();
        } catch (Exception ex) {
              ex.printStackTrace();
        }



    String regex = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(content);
    while (m.find()) {
    if(!finalResult.contains((m.group())))
      finalResult.add(m.group());
    }
} finally {
   for(String res: finalResult){
       System.out.println(res);
    }
}