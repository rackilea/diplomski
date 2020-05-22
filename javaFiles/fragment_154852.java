private void shareApplication() {
    ApplicationInfo app = getApplicationContext().getApplicationInfo();
    String filePath = app.sourceDir;

    Intent intent = new Intent(Intent.ACTION_SEND);

    // MIME of .apk is "application/vnd.android.package-archive".
    // but Bluetooth does not accept this. Let's use "*/*" instead.
    intent.setType("*/*");

    // Append file and send Intent
    File originalApk = new File(filePath);

    try {
        //Make new directory in new location
        File tempFile = new File(getExternalCacheDir() + "/ExtractedApk");
        //If directory doesn't exists create new
        if (!tempFile.isDirectory())
            if (!tempFile.mkdirs())
                return;
        //Get application's name and convert to lowercase
        tempFile = new File(tempFile.getPath() + "/" + getString(app.labelRes).replace(" ","").toLowerCase() + ".apk");
        //If file doesn't exists create new
        if (!tempFile.exists()) {
            if (!tempFile.createNewFile()) {
                return;
            }
        }
        //Copy file to new location
        InputStream in = new FileInputStream(originalApk);
        OutputStream out = new FileOutputStream(tempFile);

        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
        System.out.println("File copied.");
        //Open share dialog
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));
        startActivity(Intent.createChooser(intent, "Share app via"));

    } catch (IOException e) {
        e.printStackTrace();
    }
}