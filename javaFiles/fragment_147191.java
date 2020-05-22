@Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub

        String path=Environment
                .getExternalStorageDirectory().getPath() + "/SimonSong.mp3";
        Log.e("simon", "Path is "+path);
        Intent intent = new Intent();
        intent.setAction(Constants.BROAD);
        intent.putExtra("test", path);
        sendBroadcast(intent);

        super.onPostExecute(result);
    }

    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub
        // Toast.makeText(this, "async class is called",
        // Toast.LENGTH_LONG).show();
        Log.e("simon", "async class is called");
        int count;
        try {
            URL url = new URL(params[0]);
            URLConnection conection = url.openConnection();
            conection.connect();

            int lenghtOfFile = conection.getContentLength();
            Log.e("simon", "download is started");
            InputStream input = new BufferedInputStream(url.openStream(),
                    10 * 1024);

            OutputStream output = new FileOutputStream(Environment
                    .getExternalStorageDirectory().getPath() + "/SimonSong.mp3");
            byte data[] = new byte[1024];
            long total = 0;
            Prog pg = new Prog();
            while ((count = input.read(data)) != -1) {
                total += count;

                int temp = (int) ((total * 100) / lenghtOfFile);                
                //Log.e("simon", "Downloading completed " + temp + " %");
                output.write(data, 0, count);
                pg.setUpdate(temp);
            }

            output.flush();
            output.close();
            input.close();




            //Log.e("simon", "download is finished");

        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        // TODO Auto-generated method stub
        super.onProgressUpdate(values);
        //Log.e("simon","Value  :  "+values[0]);
    }


}