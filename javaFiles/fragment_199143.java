@Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
        // For sending Broadcast
        Intent intent = new Intent();
        intent.setAction("BROWSER_STOPPED");
        sendBroadcast(intent);
    }