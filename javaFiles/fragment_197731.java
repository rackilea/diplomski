private Handler messageHandler = new Handler() {

                public void handleMessage(Message msg) {
                    final int what = msg.what;
                    switch(what) {
                    case DO_UPDATE_TEXT: 
                     String result = msg.arg1;
                     doUpdate(); 
                     break;
                    }
                }
            };

    @Override
    public void getWebserviceResponse(final String result) {
           Message msg = handler.obtainMessage();
           msg.what = DO_UPDATE_TEXT;
           msg.obj = result;

           messageHandler.sendMessage(msg);
        }