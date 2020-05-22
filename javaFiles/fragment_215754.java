final int[] arr = new int[100];
Thread one = new Thread() {
    public void run() {
        // synchronized (arr) {
            for (int i = 0; i < arr.length * 100000; i++) {
                arr[i % arr.length]--;
            }
        // }
    }
};
Thread two = new Thread() {
    public void run() {
        // synchronized (arr) {
            for (int i = 0; i < arr.length * 100000; i++) {
                arr[i % arr.length]++;
            }
        //}
    }
};
one.start();
two.start();
one.join();
two.join();
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}