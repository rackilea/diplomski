class Downloader extends AsyncTask<URL, Void, Void> {
    String site = getResources().getString(R.string.sched_hd_url);
    File sdCard = Environment.getExternalStorageDirectory();
    File dir = new File(sdCard.getAbsolutePath() + "/directory/");
    File file = new File(dir, "file.html");

    @Override
    protected Void doInBackground(URL... uri) {
        FileOutputStream out = null;
        if (file.exists()) {
            try {
                file.delete();
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            URL url = new URL(site);
            HttpURLConnection yc = (HttpURLConnection) url.openConnection();
            BufferedInputStream in = new BufferedInputStream(
                    new URL(site).openStream());
            out = new FileOutputStream(file);
            int total = 0;
            int count;
            byte data1[] = new byte[1024];
            while ((count = in.read(data1)) != -1) {
                out.write(data1);
                total += count;
            }
            in.close();
            out.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected void onPostExecute(Void result) {
        progress.setVisibility(View.INVISIBLE);
        finish();
    }
}