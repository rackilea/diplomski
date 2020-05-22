public class QueryServer extends AsyncTask<String, Void, Wrapper> { 

    protected Wrapper doInBackground(String... serverAddress) {
        Log.d("QueryServer", ""+serverAddress[0]);
        MCQuery mcQuery = new MCQuery("" + serverAddress[0] ,25565);
        QueryResponse response = mcQuery.basicStat();

        int onlinePlayers = response.getOnlinePlayers(); //first vaule
        int maxPlayers = response.getMaxPlayers();  //second vaule

        Log.d("MCQuery", "" + onlinePlayers + " onlinePlayers");
        Wrapper w = new Wrapper();
        w.onlinePlayers = onlinePlayers;
        w.maxPlayers = maxPlayers;
        return w;

    }

    protected void onPostExecute(Wrapper w){

        TextView onlinePlayersView = (TextView) findViewById(R.id.online_players);

        onlinePlayersView.setText(""+w.onlinePlayers+"/"+ w.maxPlayers); //i need to pass Maxplayers to use it here


    }