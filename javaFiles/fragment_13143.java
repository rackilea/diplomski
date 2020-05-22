private void onCreate() {
    final ProgressDialog dialog = ProgressDialog.show(this, "Please wait..", "Doing stuff..", true);

    Thread t = new Thread() {
        public void run() {
            //do some serious stuff...
            SwingUtilities,invokeLater(new Runnable() {
                public void run() {
                    dialog.dismiss();           
                }
            });
            stepTwo();
        }
    };
    t.start(); 
}