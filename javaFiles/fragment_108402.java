public static void main(String[] args) {
    Thread th1 = new Thread(new ABCThread_2(false, true));
    Thread th2 = new Thread(new ABCThread_2(true, false));
    th1.start();
    th2.start();
}