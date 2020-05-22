class MyThread extends Thread {

    public MyObject myObject;

    @Override
    public void run() {
        myObject = new MyObject();

        /* Do stuff */
    }

}