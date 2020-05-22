void saveData(String FILENAME, Context mContext) {

        Log.d(TAG, FILENAME);

        try {
               OutputStreamWriter outputStreamWriter = new OutputStreamWriter(mContext.openFileOutput(FILENAME, Context.MODE_PRIVATE));
               outputStreamWriter.write("hallo welt");
               outputStreamWriter.close();
           }
           catch (IOException e) {
               Log.e(TAG, "File write failed: " + e.toString());
           }
    }