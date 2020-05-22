String boundary = "AaB03x";
String body = "--" + boundary + "\r\n"
            + "Content-Disposition: form-data; name=\"asd\"\r\n"
            + "\r\n"
            + "123\r\n"
            + "--" + boundary + "\r\n"
            + "Content-Disposition: form-data; name=\"pics\"; filename=\"file1.txt\"\r\n"
            + "Content-Type: text/plain\r\n"
            + "\r\n"
            + "555\r\n"
            + "--" + boundary + "--";

StringBuffer str = new StringBuffer();
str.append("POST /tst/query.php HTTP/1.1\r\n"
         + "Host: myhost.com\r\n"
         + "User-Agent: sampleAgent\r\n"
         + "Content-type: multipart/form-data, boundary=\"" + boundary + "\"\r\n" 
         + "Content-Length: " + body.length() + "\r\n"
         + "\r\n"
         + body
);