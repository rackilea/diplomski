@Override
    public void onTaskRemoved(Intent rootIntent) {
            Intent intent = new Intent(this, DummyActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
    }