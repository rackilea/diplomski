public void send() {
    try {
        File myFile = new File("/storage/emulated/0/saved_images/Image-test.jpg");
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        String ext = myFile.getName().substring(myFile.getName().lastIndexOf(".") + 1);
        String type = mime.getMimeTypeFromExtension(ext);
        Intent sharingIntent = new Intent("android.intent.action.SEND");
        sharingIntent.setType(type);
        sharingIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(myFile));
        startActivity(Intent.createChooser(sharingIntent, "Share using"));
    } catch (Exception e) {
        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}