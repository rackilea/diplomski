@SuppressWarnings("unused")
public static void main(String[] args) {
    Thread threads[] = new Thread[2];
    //loop1
    for(int i=1; i<=2; i++) {
        threads[i-1] = new Cls1();
    }

    for (Thread thread: threads) {
        thread.join();
    }

    //loop2
    for(int j=1; j<=2; j++) {
        Cls2 c2 = new Cls2();
    }
}