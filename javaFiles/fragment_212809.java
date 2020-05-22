public static void main(String[] args) {

    final int M = 100;
    final int N = 4;
    final int[] array = new int[M];
    final Object lock = new Object(); // LOCK!!

    for (int b = 0; b < M; b++) {
        array[b] = b;
    }

    for (int p = 0; p < N; p++) {
        final int i = p;
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) { // SYNCHRONIZED BLOCK INSTEAD OF SYNCHRONIZED METHOD
                    for (int a = i * (M / N); a < (i + 1) * (M / N); a++) {
                        System.out.println("Thread " + (i + 1) + ":" + array[a]);
                    }
                }
            }
        }).start();
    }
}