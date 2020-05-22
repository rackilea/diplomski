StringBuilder builder = new StringBuilder();
builder.append("HTTP/1.1 200 OK\r\n");
builder.append("Content-Type: text/plain; charset=utf-8\r\n");
builder.append("Content-Length:" + data.length() + "\r\n\r\n);
builder.append(data);
bw.write(builder.toString());