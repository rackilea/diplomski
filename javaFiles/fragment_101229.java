private void processFile(Context context, String fileName) {
    BufferedReader br;

    File file = new File(context.getExternalFilesDir(null) + "/" + FILE_DIR, fileName);
    try {
        FileReader fr = new FileReader(file);
        br = new BufferedReader(fr);
    } catch (FileNotFoundException e) {
        Log.e("couldn't read from external file");
        return;
    }

    try {
        String line;
        while ((line = br.readLine()) != null) {
            // here you put your code
            processLine(line);
        }
    } catch (IOException e) {
        Log.e("couldn't process line");
    } finally {
        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            Log.e("Failed to close BufferedReader");
        }
    }
}