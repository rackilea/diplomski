try {
    char[] buffer = new char[2048];
    int charsRead = 0;
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    while ((charsRead = in.read(buffer)) != -1) {
        String message = new String(buffer).substring(0, charsRead);
        Log.e("In While", "msg :"+message);   
    }
}