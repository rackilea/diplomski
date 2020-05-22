PrintWriter writer = new PrintWriter(socket.getOutputStream());
writer.println("HTTP/1.0 200 Ok");
writer.println("Set-Cookie key=value Max-Age=8640");
writer.println("Content-Type text/html");
writer.println()//important
//send your body here
writer.flush();//send message