readExcel(String test, String filename) {
    int returnCode = client.cwd("/"+test);
    if ( FTPReply.isPositiveCompletion( returnCode ) ) {
        is =  client.retrieveFileStream(filename");
        //do the processing
    }
    else {
        System.out.println("Cannot cd to " + filename + " errorcode="+returnCode);
    }
}