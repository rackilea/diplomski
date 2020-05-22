public void onClick(View v) {
    new Thread(new Runnable() {
        public void run() {

            try {
                URL url = new URL("http://");

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                try {
                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);

                    conn.connect();
                } finally {
                    conn.disconnect();
                }

            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }
    }).start();
}