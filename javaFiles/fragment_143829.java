private class MyAsyncImagesDownload extends AsyncTask<URL, Integer, Long> {
    protected Long doInBackground(URL... urls) {
        int count = urls.length;
        long totalSize = 0;

        //a loop can be like this
        for (int i = 0; i < count; i++) {
            totalSize += Downloader.downloadFile(urls[i]);
            publishProgress((int) ((i / (float) count) * 100));
            if (isCancelled()) break;
        }
        return totalSize;
    }


    protected void onPostExecute(Long result) {
        showDialog("Downloaded " + result + " bytes");
    }
}