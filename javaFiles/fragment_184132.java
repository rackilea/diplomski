@Override
protected void onActivityResult (int requestCode, int resultCode, Intent data) {
    if (requestCode == REQ_CODE) {
        // dismiss notification
        notificationManager.cancel(0);

        // handle your action
        // ...
    }
}