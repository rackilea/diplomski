Elements elements = doc.select("span.st"); 
for (Element e : elements) {        
    out.println("<p>Text : " + e.text()+"</p>");
    out.println(extractEmail(e.text()));
}

// ...
public static String extractEmail(String str) {
   Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-    9-.]+").matcher(str);
   while (m.find()) {
       return m.group();
   }
   return null;
}