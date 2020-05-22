private static String createTable(Map map, String title)
  {
  StringBuffer sb = new StringBuffer();

  // Generate the header lines

  sb.append("<table border='1' cellpadding='3'>");
  sb.append("<tr>");
  sb.append("<th colspan='2'>");
  sb.append(title);
  sb.append("</th>");
  sb.append("</tr>");

  // Generate the table rows

  Iterator imap = map.entrySet().iterator();
  while (imap.hasNext()) {
     Map.Entry entry = (Map.Entry) imap.next();
     String key = (String) entry.getKey();
     String value = (String) entry.getValue();
     sb.append("<tr>");
     sb.append("<td>");
     sb.append(key);
     sb.append("</td>");
     sb.append("<td>");
     sb.append(value);
     sb.append("</td>");
     sb.append("</tr>");
  }

  // Generate the footer lines

  sb.append("</table><p></p>");

  // Return the generated HTML

  return sb.toString();