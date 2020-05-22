private class DownLoad extends AsyncTask<String, String, String> {

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
        logger.info("LoadDataAsync onPreExecute");
        showDialog(DOWNLOAD_ONPROGRESS);
    }

    @Override
    protected String doInBackground(String... aurl) {
        int count = 0;

        try {
            URL url = new URL(aurl[0]);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            int contentlength = urlConnection.getContentLength();
            progressDialog.setMax(contentlength);
            String PATH = "";
            File file = null;
            if (android.os.Environment.getExternalStorageState().equals(
                    android.os.Environment.MEDIA_MOUNTED)) {
                PATH = Environment.getExternalStorageDirectory()
                        + "/download/";
                file = new File(PATH);

                file.mkdirs();

                File outputFile = new File(file, "telfaz.apk");
                OutputStream fos = new FileOutputStream(outputFile);

                InputStream is = new BufferedInputStream(url.openStream());

                byte[] buffer = new byte[1024];
                long len1 = 0;
                while ((count = is.read(buffer)) != -1
                        && !downLoad.isCancelled()) {
                    len1 += count;
                    publishProgress("" + len1);
                    fos.write(buffer, 0, count);
                }
                fos.flush();
                fos.close();
                is.close();

            }
            logger.info("Success -> file downloaded succesfully. returning 'success' code");
            return Util.APK_DOWNLOAD_SUCCESS;

        } catch (IOException e) {
            logger.error("Exception in update process : "
                    + Util.getStackTrace(e));
        }
        logger.info("Failed -> file download failed. returning 'error' code");
        return Util.APK_DOWNLOAD_FAILED;
    }

    @Override
    protected void onPostExecute(String result) {
        logger.info("on DownLoad onPostExecute. result : " + result);
        progressDialog.dismiss();
        removeDialog(DOWNLOAD_ONPROGRESS);
        if (result.equalsIgnoreCase(Util.APK_DOWNLOAD_SUCCESS)) {
            Update();

        } else {
            Toast.makeText(DownloadAllContentsActivity.this,
                    getString(R.string.updateApplicationFailed),
                    Toast.LENGTH_LONG).show();

            loadDataAsync.execute();

        }

    }

    @Override
    protected void onProgressUpdate(String... values) {
        if (values != null && values.length > 0) {
            progressDialog.setProgress(Integer.parseInt(values[0]));
        }

    }


}