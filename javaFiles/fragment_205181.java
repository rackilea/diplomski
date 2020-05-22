long timeInMillis = System.currentTimeMillis();
long timeInNanos = System.nanoTime();

Timestamp timestamp = new Timestamp(timeInMillis);
timestamp.setNanos((int) (timeInNanos % 1000000000));

// ...