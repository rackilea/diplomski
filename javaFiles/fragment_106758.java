class MyThread extends Thread {
    int[] array;
    int iterations;

    public MyThread(int[] arr, int i) {
        array=arr;
        iterations = i;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++)
            System.out.println(array[i]);
    }
}

class ThreadDemo {
    public static void main(String args[]) {
        try {

            int[] arr = new int[10];
            for (int i = 0; i < 10; i++)
                arr[i] = i;

            for (int c = 0; c < 2; c++) {
                MyThread thread1 = new MyThread(arr, 3);
                MyThread thread2 = new MyThread(arr, 5);
                thread1.start();
                thread2.start();
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}