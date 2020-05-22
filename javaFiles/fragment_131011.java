File path = Environment.getExternalStoragePublicDirectory(
        Environment.DIRECTORY_PICTURES);
File file = new File(path, "DemoPicture.jpg");

try {
    // Make sure the Pictures directory exists.
    path.mkdirs();
...