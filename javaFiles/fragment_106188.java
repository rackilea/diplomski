public void serverStateWrappr(){

Handler messageHandler = new Handler() {            
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        _localstr = getStuff((String) msg.obj)
        updateAdapter(_localstr)
    }}