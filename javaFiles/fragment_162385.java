m_eventCallHandler = new EventChannel.StreamHandler() {
        @Override
        public void onListen(Object o, EventChannel.EventSink eventSink) {
            SinkBroadcastReceiver receiver = new SinkBroadcastReceiver(eventSink);
            registerReceiver(receiver, new IntentFilter(LocationUpdatesService.NOTIFICATION));
            // TODO : Save receiver in a list to call unregisterReceiver later
        }

        @Override
        public void onCancel(Object o) {

        }
    };