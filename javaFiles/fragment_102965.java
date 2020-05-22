Intent intent = new Intent(this, MusicPlaybackService.class);
    MyApplication.getAppContext().startService(intent);
    serviceConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            LocalBinder binder = (LocalBinder) service;
            musicPlaybackService = binder.getService();
            // now onServiceConnected calls on screen rotation.
        }

        public void onServiceDisconnected(ComponentName arg0) {
        }
    };
    MyApplication.getAppContext().bindService(intent, serviceConnection, BIND_AUTO_CREATE);