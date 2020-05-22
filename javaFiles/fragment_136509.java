new Thread(new Runnable() { // if already doing the checking on network thread then no need to add this thread
        @Override
        public void run() {
            try {
                URLConnection connection = new URL("image url here").openConnection();
                String contentType = connection.getHeaderField("Content-Type");
                boolean image = contentType.startsWith("image/"); //true if image 
                Log.i("IS IMAGE", "" + image);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }).start();