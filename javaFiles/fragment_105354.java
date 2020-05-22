private WeakReference<MainActivity> activityReference;

    private HttpRequestTask(String serverAdress, MainActivity context) {
        this.serverAdress = serverAdress;
        this.activityReference = new WeakReference<>(context);

        dialog = new AlertDialog.Builder(activityReference.get())
                .setTitle("HTTP Response from Ip Address:")
                .setCancelable(true)
                .create();
    }