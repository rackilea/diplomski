public class MyActivity {

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            ListenerService.LocalBinder binder = (ListenerService.LocalBinder) service;
            mListenerService = binder.getService();
            mBound = true;

            readFromService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };

    private void readFromService() {
        Integer parsedMessage = Integer.valueOf(mListenerService.getParsedMessage()); //this is the cause of the NPE

        mImageView.setImageResource(mAlertAssignments.alarmImages[parsedMessage]);

        if(parsedMessage >= 10 && parsedMessage <= 19 && parsedMessage != 0) {
            mTextView.setText(mAlertAssignments.alertTextMessages[parsedMessage]);
        } else {
            mBlinkView.setText(mAlertAssignments.alertTextMessages[parsedMessage]);
        }
    }
}