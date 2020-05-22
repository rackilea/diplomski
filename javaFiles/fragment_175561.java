private boolean isConnect = false;
private class CheckConnectionTask extends AsyncTask<Void, Void, Boolean> {
@Override
protected Boolean doInBackground(Void... params) {
    try {
        InetAddress ipAddr = InetAddress.getByName("https://www.google.com");

        if (!ipAddr.isReachable(10000)) {
            return false;
        } else {
            return true;
        }

    } catch (Exception e) {
        Log.e("exception", e.toString());
        return false;
    }
}
@Override
protected void onPostExecute(Boolean result) {
    super.onPostExecute(aVoid);
    isConnect = result;
}
}