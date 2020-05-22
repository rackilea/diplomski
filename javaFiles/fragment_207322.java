private class AsyncExec extends AsyncTask<Void,Void,Void>{


    @Override
    protected Void doInBackground(Void... voids) {
        int port=80;
        try
        {
            InetAddress address = InetAddress.getByName("pool.supportxmr.com");
            Log.d("miner","Attempting to connect to " + address.toString() + " on port " + port + ".");

            Socket socket = new Socket(address, 3333);
            Log.d("miner", "Connection success");
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
        return null;
    }
}