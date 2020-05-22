private void onCreate() {
    final ProgressDialog dialog = ProgressDialog.show(this, "Please wait..", "Doing stuff..", true);

    Thread t = new Thread() {
        public void run() {
            //do some serious stuff...
            dialog.dismiss();           
        }
    };
    t.start(); 
    t.join();
    stepTwo();

}