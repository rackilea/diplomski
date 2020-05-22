OutputStream stream = socket.getOutputStream();
PrintWriter out = new PrintWriter(
    new BufferedWriter(
        new OutputStreamWriter(stream)
    )
);
out.println("test output");
out.flush(); // ensure that the string is not buffered by the BufferedWriter

byte[] data = getBinaryDataSomehow();
stream.write(data);