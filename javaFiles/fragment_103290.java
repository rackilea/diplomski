private void connectToServer() {
            try {
                mConnection.connect(getString(R.string.server_addr), new WebSocketHandler(){

                    // connection au serveur
                    @Override
                    public void onOpen(){
                        Log.d(TAG, "Connected");
                        Log.d(TAG, "First connexion, sending MAC @");
                        Log.d(TAG, "My MAC Addr: "+ macAddr);
                        mConnection.sendTextMessage(macAddr);

                    }
                    // reception d'un message text
                    @Override
                     public void onTextMessage(String payload) {

                        //TODO
                     }

                    // fermeture de la connexion
                     @Override
                     public void onClose(int code, String reason) {
                        Log.d(TAG, "Connection lost. "+reason+" error code : "+code);
                        if(code<4000){
                            reconnectToServer();
                        }
                     }
                });
            } catch (WebSocketException e) {

                Log.e(TAG, "Error on connect: "+e.toString());
                Log.d(TAG, "is connected: "+mConnection.isConnected());
            }

        }

    private void reconnectToServer() {
            try {
                if(goConnect){
                    goConnect = false;
                    Thread.sleep(1000);
                    Log.d(TAG, "DISCONNECT:");
                    // mConnection.disconnect();
                    Log.d(TAG, "ReconnectTimer Launched");
                    new ReconnectTask().run();
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }       
            }

    private class ReconnectTask extends TimerTask{
        @Override
        public void run() {
            try{
                if(totalWaitTime<HOUR_TO_MS){
                    if(!mConnection.isConnected()){
                        int waitTime= random.nextInt(MAX_TO_WAIT - MIN_TO_WAIT + 1) + MIN_TO_WAIT;
                        Log.d(TAG, "Next tentative to connect in "+waitTime+" ms");
                        totalWaitTime +=waitTime;
                        reconnectTimer.schedule(new ReconnectTask(), waitTime);
                        connectToServer();
                    }else{
                        Log.d(TAG, "Connected to the server again");
                        reinitializeReconnection();
                    }
                }else throw new InterruptedException("Attempt to connect to the server during 1 hours without success");
            }catch(InterruptedException e){
                Log.d(TAG, e.getMessage());
            }

        }
    }

private void reinitializeReconnection(){
        reconnectTimer.purge();
        goConnect = true;
        totalWaitTime = 0;
    }