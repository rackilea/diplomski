Pattern p = Pattern.compile("</[^>]+>");
while((currentLine = br.readLine())!= null){
    System.out.println("Input text is as follows:");
    System.out.println(currentLine);
    System.out.println("Output Formatted text is as follows:");
    Matcher m = p.matcher(currentLine);
    System.out.println(m.replaceAll("$0\n"));
}