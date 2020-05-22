Handler handler = new Handler(new Handler.Callback() {
    @Override
    public boolean handleMessage(Message message) {
        smth();
        ...
        return messageHandled;
    }
});