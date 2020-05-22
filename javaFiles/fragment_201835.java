private static TimerTask perform(){
    try {
        //logging on to FTP-Server

        InputStream  in = client.retrieveFileStream("./htdocs/pwiMain/main.txt");
        BufferedInputStream inbf = new BufferedInputStream(in);
        int bytesRead;
        byte[] buffer = new byte[1024];
        String wholeFile = null;
        String wholeCred = null;
        String[] contents;
        while((bytesRead = inbf.read(buffer)) != -1){
            wholeFile = new String(buffer,0,bytesRead);
        }
        inbf.close();  // ADDED

        InputStream pw = client.retrieveFileStream("./htdocs/pwiMain/cred_pwd.txt");
        BufferedInputStream pwbf = new BufferedInputStream(pw);
        int pwBytesRead; // YOU DON'T NEED THIS, you could reuse the previous one
        byte[] pwBuffer = new byte [1024]; // DITTO
        while((pwBytesRead = pwbf.read(pwBuffer)) != -1){
            wholeCred = new String(pwBuffer,0,pwBytesRead);
        }
        pwbf.close(); // ADDED

        sentPassword =  wholeFile.substring(sentPassword.indexOf("#lap"));
        md5hash = wholeCred;
        contents = sentPassword.split("\\r\\n|\\n|\\r");
        System.out.println("contents:    " + contents[0] + "   " + contents[1]);

        //check the password


    } catch (IOException e) {
            // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("ioexception");
    } finally {

    }
    return null;
}