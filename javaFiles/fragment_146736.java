private class AsyncTaskRunner extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... strings) {
        boolean clicked = Boolean.parseBoolean(strings[0]);
        String user = strings[1];
        String pass = strings[2];
        ...
    }
}