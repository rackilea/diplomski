URL url = new URL("http://stackoverflow.com/questions/1381617");
URLConnection con = url.openConnection();
Pattern p = Pattern.compile("text/html;\\s+charset=([^\\s]+)\\s*");
Matcher m = p.matcher(con.getContentType());
/* If Content-Type doesn't match this pre-conception, choose default and 
 * hope for the best. */
String charset = m.matches() ? m.group(1) : "ISO-8859-1";
Reader r = new InputStreamReader(con.getInputStream(), charset);
StringBuilder buf = new StringBuilder();
while (true) {
  int ch = r.read();
  if (ch < 0)
    break;
  buf.append((char) ch);
}
String str = buf.toString();