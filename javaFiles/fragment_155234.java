private MessageProcesor callback;

public void setUpWebSocketHandler(WebSocketHandler handler)
{
    handler = new WebSocketHandler(){

  //first method for websockethandler

        @Override
        public void onOpen() {


            //here i create a json format string to be sent to my         server that returns something afterwards
            String output = json.toString();
            Log.d("OUTPUT+" , output);
            Log.d("onOpen", "Status: Connected to " + wsuri);
            mConnection.sendTextMessage(output);
        }



//second method for websockethandler
        @Override
        public void onTextMessage(final String payload) {

            Log.d("onTextMessage", "Response: " + payload);
            JSONObject jsonObj = null;
            try {
                jsonObj = new JSONObject(payload);
            } catch (JSONException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {

                String type = jsonObj.getString("type");
                switch (type) {
                    case "xxx":
                        //authEvent
                        System.out.println("xxx");
                        break;
                    case "yyy":
                        //userOnlineEvent
                        System.out.println("yyy");
                        break;
                    case "zzz":
                        System.out.println("zzz");

                        break;
                    case "userListToken":

                        userList = getUserList(payload);
                        callback.processMessage(userList);

                        break;


                    default:
                        System.out.println("DefaultCase");
                        break;
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }



        }

//third method for websockethandler

        @Override
        public void onClose(int code, String reason) {
            Log.d("onClose", "Connection lost.");
        }

    };
}



public String getUserList(final String payload)
{
    final Thread connectthread;
    connectthread = new Thread(
            new Runnable()
            {
                public void run()
                {
                    try {
                        //here i create a URL, send post request to it and i get a response with userlist
                        HttpClient client = new DefaultHttpClient();

                        HttpGet post = new HttpGet(url);


                        HttpResponse response = client.execute(post);
                        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));


                        while ((userList = rd.readLine()) != null) {
                            System.out.println(userList);
                            Log.d("HTTP GET RESPONSE", "Response: " + userList);

                        }



                    } catch (JSONException | IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
    );



    connectthread.start();
    try
    {
        connectthread.join();
    }
    catch (Exception e)
    {
        Log.i("error","Error!!");
    }

    System.out.println("userListToken");
    return userList;
}