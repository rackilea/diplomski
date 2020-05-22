public class MyService extends Service {
    private static final String TOKEN = "msg-token";

    // XXX Implement Service methods here.

    private void notifyService(Object someObject) {
        // XXX Process result from cloud service interaction.
    }

    private class MyCloudClient implements Runnable {
        @Override
        public void run() {
            // XXX Interact with cloud service here.

            Bundle msgInfo = new Bundle();
            msgInfo.putSerializable(TOKEN, msgInfo);

            Message msg = Message.obtain();
            msg.setData(msgInfo);
            MyService.this.msgHandler.sendMessage(msg);        
        }
    }

    private Handler msgHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle msgInfo = msg.getData();
            Object someObject = msgInfo.getSerializable(TOKEN);
            MyService.this.notifyService(someObject);
        }
    };
}