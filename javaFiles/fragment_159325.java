class ClientTask extends AsyncTask<Void, Void, Void> // or whatever you want to pass in
{

        public static String ip = "10.0.2.1";
        public static int port = 5061;
        Socket socket;
        public DataInputStream dis;
        public DataOutputStream dos;
        public String message;

        @Override
        protected Void doInBackground(Void... params) {


/* set up our socket and open a stream to read */

                 try {
                socket = new Socket(ip, port);
        dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));           

            } catch (Exception e) {
                Log.i("AsyncTank class", "Socket has some trouble opening");
            }

/*heres the stuff your looking for to listen to a socket all day long*/

while(socket.isConnected()){
                String mymessage=dis.readLine(); //readline blocks
/* do something with your message */    
publishProgress(mymessage); //publishes update to main UI thread            
                        }
                }

            }
            return null;
        }



@Override
    protected void onProgressUpdate(String... messages) {

     Toast.makeText(this, messages,Toast.LENGTH_LONG).show(); //announce updates on incoming socket

}


}