@Override
    protected void onStart()
    {
        super.onStart();

        // Check Location sensor

        // Check server accessibility
        BackendCheck backendCheck = new BackendCheck(this);
        backendCheck.setServerListener(new BackendCheck.BackendCheckListener()
        {
            @Override
            public void onServerIsDown()
            {
                MainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        displayErrorDialog();
                    }
                });
            }
        });
        backendCheck.start();
    }