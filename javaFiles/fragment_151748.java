File folder = Environment.getExternalStoragePublicDirectory(Environmeng t.DIRECTORY_DOWNLOADS);
 for(File file:folder.listFiles()){
  try {
    String DFOLDER = FileUtils.readFileToString(file);
    Log.i("File Contents ", DFOLDER);
  } catch (IOException e) {
    Toast.makeText(getApplicationContext(), "Failed!", Toast.LENGTH_SHORT).show();
  }
}