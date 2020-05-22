public void openFileExplorer() {
    File mPath = new File(Environment.getExternalStorageDirectory() + "/");
    fileDialog = new FileDialog(this, mPath);
    fileDialog.addFileListener(new FileDialog.FileSelectedListener() {
        public void fileSelected(File file) {
            Log.d(getClass().getName(), "selected file " + file.toString());
            chosenFile = file.toString();
generateMFCC(chosenFile);

        }
    });
    fileDialog.showDialog();
}