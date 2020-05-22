String setCookieField = connection.getHeaderField("Set-Cookie");
// check that cookie is not null
String[] cookieFields = cookie.split(";");
// the cookie name/value pair is typically first
String[] cookieNameValue = cookieFields[0].split("=");
String cookie = cookieNameValue[1];
int size = cookie.getBytes("UTF-8").length;