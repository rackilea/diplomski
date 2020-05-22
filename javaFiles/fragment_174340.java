File sdcard = Environment.getExternalStorageDirectory();

//Get the text file
File file = new File(sdcard,"scanned.txt");

//Read text from file
StringBuilder text = new StringBuilder();

try {
    BufferedReader br = new BufferedReader(new FileReader(file));
    String line;

    while ((line = br.readLine()) != null) {
        text.append(line);
        text.append('\n');
    }
}
catch (IOException e) {
    //You'll need to add proper error handling here
}