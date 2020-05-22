final ProgressDialog progressDialog = new ProgressDialog(this);
progressDialog.setTitle("Downloading Image ...");
progressDialog.setMessage("Download in progress ...");
progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
progressDialog.setProgress(0);
progressDialog.setMax(100);
progressDialog.show();

final Handler downloadProgressHandler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        progressDialog.setProgress(100 * msg.arg1 / msg.arg2);
        if (progressDialog.getProgress() == progressDialog.getMax()) {
            progressDialog.dismiss();
        }
    }
};

new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            URL url = new URL("<your_url>");
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            //urlConnection.setDoOutput(true);
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            int totalSize = urlConnection.getContentLength();
            ByteArrayOutputStream receivedBytesStream = new ByteArrayOutputStream();
            int downloadedSize = 0;
            byte[] buffer = new byte[1024];
            int bufferLength = 0;
            while ((bufferLength = inputStream.read(buffer)) > 0 ) {
                receivedBytesStream.write(buffer, 0, bufferLength);
                downloadedSize += bufferLength;
                Message msg = new Message();
                msg.arg1 = downloadedSize;
                msg.arg2 = totalSize;
                downloadProgressHandler.sendMessage(msg);
            }
            receivedBytesStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}).start();