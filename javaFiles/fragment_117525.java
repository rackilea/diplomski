PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
writer.println("GET / HTTP/1.1");
writer.println("Header: value");
writer.println(); // end of header
...
writer.flush(); // if you need to flush the buffer before closing
writer.close(); // when done - flushes and closes