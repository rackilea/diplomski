public void share() {
    String filePath=getApplicationContext().getFilesDir().getPath().toString() + "/screenshot.png";
    String path;
    try {
        path = Images.Media.insertImage(getContentResolver(), filePath, "title", null);
        Uri screenshotUri = Uri.parse(path);

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/png");
        share.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        share.putExtra(Intent.EXTRA_STREAM, screenshotUri);
        startActivity(Intent.createChooser(share, "Teilen via"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}