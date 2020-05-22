try {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(getAssets().open("filename.txt")));

    // do reading, usually loop until end of file reading  
    String mLine = reader.readLine();
    while (mLine != null) {
       //process line
       ...
       mLine = reader.readLine(); 
    }

    reader.close();
} catch (IOException e) {
    //log the exception
}