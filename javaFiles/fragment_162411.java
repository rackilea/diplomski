byte [] buffer = new byte[1024];  // or bigger
while(true) {
    int nosRead = inputStream.read(buffer);
    if (nosRead < 0) {
        break;
    }

    // Note that this is a bit dodgy, given that the data you are converting is
    // binary.  However, if the purpose is to see what embedded character data 
    // looks like, and if the proxy's charset matches the text charset used by 
    // the client-side JDBC driver for encoding data, this should achieve that.
    System.out.println("Read returned : " + nosRead);
    System.out.println("message read : " + new String(buffer, 0, nosRead));

    outputStream.write(buffer, 0, nosRead);
    outputStream.flush();
}