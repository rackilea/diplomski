// Query and use the result in another thread
Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        // Get a Realm instance for this thread
        Realm realm = Realm.getInstance(context);
...