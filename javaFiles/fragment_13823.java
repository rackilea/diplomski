new Thread() {
    @Override
    public void run() {
        // long operations goes here
        // user decided to close fragment
        Activity activity = getActivity();
        // here 'activity' is null because fragment is destroyed
        }
}.start();