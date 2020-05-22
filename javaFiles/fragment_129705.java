Handler locationPrompt = new Handler(){

    @Override
    public void handleMessage(Message msg) {
        // TODO Auto-generated method stub
        if(msg.what==SUBJECT){
            onLocationChanged(location);
            sendEmptyMessageDelayed(SUBJECT, REFRESH);
        }
    }

};