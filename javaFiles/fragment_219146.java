public void upload() {
    try {
        URL url = new URL(URLPath);
        connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(30000);
        connection.setReadTimeout(30000);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.connect();
        // run uploading activity within a Thread
        Thread t = new Thread() {
            public void run() {
                is = connection.getInputStream();
                if (is == null) {
                    throw new RuntimeException("stream is null");
                }
                // sleep 2 seconds before "stop uploading" button appears
                mHandler.postDelayed(new Runnable() {
                    public void run() {
                        mBtnStop.setVisibility(View.VISIBLE);
                    }
                }, 2000);
            }
        };
        t.start();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
        if (connection != null) {
            connection.disconnect();
        }
    }
}