Sting str = "{\"question\" : \"some question\", \"answer\": " + 
  "\"some answer that might have \"quotes\" in it.\", \"name\": \"some name\"}";
Matcher m = Pattern.compile
    ("(?s)(?i)(\"answer\"\\s*:\\s*\")(.+?)(?=\"\\s*[,}])").matcher(str);
StringBuffer buf = new StringBuffer();
while (m.find()) {
    m.appendReplacement(buf, m.group(1) + m.group(2).replace("\"", "\\\\\""));
}
m.appendTail(buf);  
System.out.printf("%s%n", buf);