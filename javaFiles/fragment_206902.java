@Override
protected void onPostExecute(Void result) {
    super.onPostExecute(result);
    if (exception.contains("java.net.UnknownHostException")) {
        MainActivity.showDialog();
        Log.i("Error Message", "ERROR MESSAGE SHOWN");
    }
}