@Override
protected Boolean doInBackground(Boolean saveToAppfolder, String... arg) {

    String PATH = "";
    if (saveToAppfolder) {
        Environment.getExternalStorageDirectory() + "/AppFolder/";
    } else {
        //OTHER Folder
    }
}