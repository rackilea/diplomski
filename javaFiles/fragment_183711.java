//Path to sdcard
File sdcard = Environment.getExternalStorageDirectory();
//Load the file
File file = new File(sdcard,"file.json");
//Read text from file
StringBuilder text = new StringBuilder();
try {
    BufferedReader br = new BufferedReader(new FileReader(file));
    String line;
    while ((line = br.readLine()) != null) {
        text.append(line);
        text.append('\n');
    }
    br.close();
}
catch (IOException e) {
    //You'll need to add proper error handling here
}