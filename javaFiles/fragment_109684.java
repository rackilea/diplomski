public class GcmKeepAliveBroadcastReceiver extends BroadcastReceiver {

        private GcmKeepAlive gcmKeepAlive;

        @Override
        public void onReceive(Context context, Intent intent) {
            System.out.println("inside gcm keep alive receiver");
            gcmKeepAlive = new GcmKeepAlive(context);
            gcmKeepAlive.broadcastIntents();

        }

    }