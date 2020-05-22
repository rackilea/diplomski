@Override
    protected void onDestroy() {
        pusher.disconnect();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
        super.onDestroy();
    }