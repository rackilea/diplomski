SharedPreferences prefs = getSharedPreferences(LauncherPage.PREFS, MODE_PRIVATE);
int currSize = prefs.getInt("size", size);
if (currSize !=0) {
    seekSpq.setProgress(currSize);
    seekTxt.setText(Integer.toString(currSize) + " pixels");
}else{
    seekSpq.setProgress(300);
}