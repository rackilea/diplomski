public ArrayList<String> contactServer(){
    final URL url = new URL(serverURL);
    final URLConnection connection=url.openConnection();
    connection.setDoOutput(true);
    /*
     * ...
     * write your POST data to the connection.
     * ...
     */
    final BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    final char[] buffer=new char[Integer.parseInt(connection.getHeaderField("Content-Length"))];
    int bytesRead=0;
    while (bytesRead < buffer.length){
        bytesRead += br.read(buffer, bytesRead, buffer.length - bytesRead + 1);
    }
    final JSONArray arr = new JSONArray(new String(buffer));
    final ArrayList<String> ret = new ArrayList<String>(arr.length());
    for (int i=0; i<arr.length(); i++) {
        ret.add(arr.get(i));
    }
    return ret;
}