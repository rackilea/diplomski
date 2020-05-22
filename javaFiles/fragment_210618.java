// Handle Automatic E-Mail Sending in a new Thread
new Thread(new Runnable() {
    @Override
    public void run() {
        Bundle bundle = new Bundle();
        bundle.setString("toast","I want to display this message");
        Message msg = handler.obtainMessage(MyHandler.MESSAGE_TOAST);
        msg.setData(bundle);
        msg.sendToTarget();
        bundle.setBoolean("returnValue", EMailSender.SendEmail());
        msg = handler.obtainMessage(MyHandler.THREAD_RETURN);
        msg.setData(bundle);
        msg.sendToTarget();
   }
}).start();