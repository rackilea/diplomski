mHandler.post(new Runnable() {
    public void run(){
        //Be sure to pass your Activity class, not the Thread
        AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
        //... setup dialog and show
    }
});