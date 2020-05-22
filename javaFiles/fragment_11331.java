Thread t = new Thread() {
    public void run() {
        // Do something on another thread
        PopulatePeopleList();
    }
};
t.start();