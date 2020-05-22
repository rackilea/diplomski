FileInputStream is;
BufferedReader reader;
final File file = new File("/sdcard/text.txt");

if (file.exists()) {
    is = new FileInputStream(file);
    reader = new BufferedReader(new InputStreamReader(is));
    String line = reader.readLine();
    while(line != null){
        Log.d("StackOverflow", line);
        line = reader.readLine();
    }
}