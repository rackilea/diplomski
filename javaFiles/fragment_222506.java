class MyRunable implements Runnable {

    Callback c; // need a callable instance to update the text filed

    public MyRunable(Callback c) {// pass the callback when init your thread
        this.c = c;
    }

    public void run() {
        String s=// some work reading from System.in
        this.c.updateText(s); // after everything is done, call the callback method to update the text to the JTextField.
    }

}