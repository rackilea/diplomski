public static void saveState(Context context){

    String data = age + "," ;
    FileOutputStream fos;

    try {
        fos = context.openFileOutput("state", 0);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
        outputStreamWriter.write(data);
        outputStreamWriter.close();
    }
    catch (IOException e) {
        Log.e("Exception", "File write failed: " + e.toString());
    } 
}