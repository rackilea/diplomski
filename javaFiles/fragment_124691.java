HashMap<String, String> data = new HashMap<>();
    data.put("username", "");//define the value
    data.put("password", "");//define the value
    data.put("is_admin", "");//define the value

    SendData sendData = new SendData(this, "", data); //defie the context and url properly
    sendData.setOnDataSent(new SendData.OnDataSent() {
        @Override
        public void onSuccess(String response) {
            //parse the response 
        }

        @Override
        public void onFailed(String error) {
            //something went wrong check the error
        }
    });
    sendData.send();