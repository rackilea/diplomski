new Thread(new Runnable() {
        public void run() {
            URL url = null;
            try { url = new URL("http://c24871.shared.hc.ru/Extra.txt");
            } catch (MalformedURLException e) { e.printStackTrace(); }
            connection = null;
            try { connection = url.openConnection();
            } catch (IOException e) { e.printStackTrace(); }
            Log.d(TAG, String.valueOf(connection.getLastModified()));


        }
    }).start();