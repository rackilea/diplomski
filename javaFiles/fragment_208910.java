org.apache.commons.httpclient

final HttpClient httpClient = new HttpClient();

String url; // your URL
String body; // your JSON
final int contentLength = body.length();

PostMethod postMethod = new PostMethod(url);
postMethod.setRequestHeader("Accept", "application/json");
postMethod.setRequestHeader("Content-Type", "application/json; charset=utf-8");
postMethod.setRequestHeader("Content-Length", String.valueOf(contentLength));
postMethod.setRequestEntity(new StringRequestEntity(body, "application/json", "utf-8"));

final int statusCode = httpClient.executeMethod(postMethod);
if (statusCode != 200) 
    throw new java.io.IOException(statusCode + ": " + HttpStatus.getStatusText(statusCode));

java.io.InputStream responseBodyAsStream = postMethod.getResponseBodyAsStream();
java.io.StringWriter writer=new StringWriter();
org.apache.commons.io.IOUtils.copy(responseBodyAsStream,writer,java.nio.charset.StandardCharsets.UTF_8);

String responseJSON=writer.toString();