BufferedReader reader;

try{
    final InputStream file = getAssets().open("text.txt");
    reader = new BufferedReader(new InputStreamReader(file));
    String line = reader.readLine();
    while(line != null){
        Log.d("StackOverflow", line);
        line = reader.readLine();
    }
} catch(IOException ioe){
    ioe.printStackTrace();
}