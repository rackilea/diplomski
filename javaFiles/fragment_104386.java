protected Integer doInBackground(Void... params) {
    publishProgress(data);
}

protected void onProgressUpdate(SocketData... data) {
    GetPacket pack = new GetPacket();
    AsyncTask<SocketData, Integer, Integer> running = pack.execute(data[0]);
}