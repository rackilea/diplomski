String query = "foo=hello&bar=option2&action=send";
String charset = "UTF-8";

URLConnection connection = new URL("http://example.com/page.aspx").openConnection();
connection.setDoOutput(true); // Triggers POST method.
connection.setRequestProperty("Accept-Charset", charset);
connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
connection.getOutputStream().write(query.getBytes(charset));