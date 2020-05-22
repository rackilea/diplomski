// ... existing code ...

Date today = new Date();
String content = today.toString();
String httpResponse = "HTTP/1.1 200 OK\r\n" +
                      "Content-Type: text/plain\r\n" +
                      "Content-Length: " + content.length() + "\r\n" +
                      "Connection: keep-alive\r\n" +
                      "\r\n" +
                      content;
client.getOutputStream().write(httpResponse.getBytes());
client.getOutputStream().flush();
System.out.println("Sent: "+httpResponse);

// ... existing code ...