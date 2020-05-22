public static void main(String[] args) {

    Thread myThread = new Thread(new Updater(myTextArea));
    myThread.start();

}