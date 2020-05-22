@Override
    public void WillYouAccept(final String caller) {
        final Connection f = new Connection();
        ShiftView(f);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                f.updateInitiator(caller);
            }
        });
    }