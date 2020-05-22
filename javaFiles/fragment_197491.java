private static void calculateB(int[] A) {
    if (A == null || A.length < 2) {
        return;
    }
    long start_time = System.nanoTime();
    int result = 0;
    double minavg = 100000;
    double avg;
    int suma = A[A.length - 1];
    int count = 1;

    for (int i = A.length - 2; i >= 0; i--) {
        count += 1;
        int previous = A[i];
        suma += previous;

        if (previous < minavg) {
            avg = (double) suma / count;
            if (minavg > avg) {
                minavg = avg;
                result = i;
            }
        }
    }

    long end_time = System.nanoTime();
    double difference = (end_time - start_time) / 1e6;
    System.out.println(result + " " + minavg + " " + difference);
}