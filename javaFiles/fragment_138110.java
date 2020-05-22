static class BluetoothInHandler extends Handler {
            private final WeakReference<YourActivityName> mActivity; 

            IncomingHandler(YourActivityName activity) {
                mActivity= new WeakReference<YourActivityName>(activity);
            }
            @Override
            public void handleMessage(Message msg)
            {
                final YourActivityName thizz = mActivity.get();
                if (thizz == null) {
                    return;
                 }
                if (msg.what == thizz.handlerState) {
                  // Do what you need
                 }
            }
    }