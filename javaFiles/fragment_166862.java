// Declare an ArrayList first 
private ArrayList<String> lineStore = new ArrayList<String>();

protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 1000 && resultCode == RESULT_OK) {
        String filePath = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
               if (line.startsWith("h")) {
                   // Store the line in the ArrayList to be used later
                   lineStore.add(line); // That's what you meant? 
               }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}