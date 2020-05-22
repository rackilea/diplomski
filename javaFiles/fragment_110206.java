@Override
public Response serve(IHTTPSession session) {
    String answer = "";
    try{
        FileReader filereader = new FileReader(contextoMain.local(localyourstorethefiles)+"/yourfolder/yourfile.html");
    BufferedReader reader = new BufferedReader(filereader);
    String line = "";
    while ((line = reader.readLine()) != null) {
        answer += line;
    }
    reader.close();

}catch(IOException ioe) {
    Log.w("Httpd", ioe.toString());
}
    return newFixedLengthResponse(answer);
}