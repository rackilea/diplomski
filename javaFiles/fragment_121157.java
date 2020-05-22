class RequestTask extends AsyncTask<String, String, String> {

    Handler handler = null;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    ...

    @Override
    protected void onPostExecute(String result) {
        if (handler != null) {
            Message message = new Message();
    message.obj = result;
            handler.sendMessage(message);
        }
    }
}