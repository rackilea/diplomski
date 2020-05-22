StringBuilder stringBuilder = new StringBuilder();
BufferedReader bufferedReader = null;
try {
String streamLength = request.getHeader("Content-Length");
int streamIntLength = Integer.parseInt(streamLength);
InputStream inputStream = request.getInputStream();
if (inputStream != null) {
bufferedReader = new BufferedReader(new InputStreamReader(
inputStream));
char[] charBuffer = new char[streamIntLength];
int bytesRead = -1;
while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
stringBuilder.append(charBuffer, 0, bytesRead);
}
} else {
stringBuilder.append("");
}
} catch (IOException ex) {
throw ex;
} 
String body = stringBuilder.toString();
//System.out.println(body);
byte[] bytes = body.getBytes();
System.out.println(StringUtils.newStringUtf16Le(bytes));