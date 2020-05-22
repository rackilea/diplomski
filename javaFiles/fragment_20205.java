public class ToRunServer extends AsyncTask<Void, Void, Boolean> {

@Override
protected Boolean doInBackground(Void... params) {
    HelloServer helloServer = null;
    try {
        helloServer = new HelloServer();
    } catch (IOException e) {
        e.printStackTrace();
    }
    try {
        HelloServer.start();
        System.out.println("SERVER START TRIED");
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("SERVER START FAILED");
        return false;
    }
}

protected void onPostExecute(Boolean result) {
}
}