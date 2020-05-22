class Update implements Runnable {
    @Override
    public void run() {
        try {
            URL url = new URL("mysite.com/app-release.apk");
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.setDoOutput(true);
            c.connect();
            String PATH = getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS).getAbsolutePath();
            File file = new File(PATH);
            File outputFile = new File(file, "app-release.apk");
            FileOutputStream fos = new FileOutputStream(outputFile);
            InputStream is = c.getInputStream();
            byte[] buffer = new byte[1024];
            int len1 = 0;
            while ((len1 = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len1);
            }
            fos.close();
            is.close();
            Intent promptInstall = new Intent(Intent.ACTION_VIEW)
                    .setDataAndType(Uri.fromFile(outputFile), "application/vnd.android.package-archive")
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(promptInstall);
        } catch (Exception ex) {
            //catch exception
        }
    }
}