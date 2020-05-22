OutputStream outstream = socket .getOutputStream(); 
PrintWriter out = new PrintWriter(outstream);

String toSend = "String to send";

out.print(toSend );