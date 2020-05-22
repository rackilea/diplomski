static class ReadLyricTask extends AsyncTask<InputStream, String, Void> {

    WeakReference<MainActivity> mMainActivity;

    ReadLyricTask(MainActivity activity) {
        mMainActivity = new WeakReference<>(activity);
    }

    @Override
    protected Void doInBackground(InputStream... inputStreams) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStreams[0]));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                publishProgress(line);
            }
        } catch (IOException e) {
            // Do nothing.
        } finally {
            try {
                inputStreams[0].close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        MainActivity activity = mMainActivity.get();
        if (activity != null) {
            activity.displayLyricLineOnTextView(values[0]);
        }
    }
}