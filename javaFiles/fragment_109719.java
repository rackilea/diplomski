private static final int MAX_SIZE = 250;
private float[] times = new float[MAX_SIZE];

private void carsPaying() {
        // ...
        while (paymentCarQueue.carsInQueue() > 0 && i < Car.getPaymentSpeed()) {
            // ...
            times[i % MAX_SIZE] = timeInFloat;
            i++;
        }
}