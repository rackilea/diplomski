private class ConnectSimpleServerTask extends AsyncTask<Void, Void, Void> {
    private Socket sock;

    private ConnectSimpleServerTask(Socket sock) {
        this.sock = sock;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            sock=new Socket("10.0.2.2", 5000);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            Log.d("NiceTag", "Net established");
        }catch (Exception ex){
            ex.printStackTrace();
            Log.d("NiceTag", "Net failed");
        }
        return null;
    }
}