InputStream in = // ...
Reader rd = new InputStreamReader(in, "USASCII");  // or whatever encoding you use

while (true) {
    String command = readLine(rd );
    if (command .equals("RAW")) {
        int length = Integer.parseInt(readLine(rd ));
        byte[] data = readData(in , length);
        if (! readLine(rd ).equals("ENDRAW")) {
            throw // an exception that indicates protocol violation
        }
    }
    else // process other commands
}