long start = System.nanoTime();
//do something
long end = System.nanoTime();

//to get the elapsed time, you can use the TimeUnit utility methods:
long elapsedInNanos = end - start;
long elapsedInSeconds = TimeUnit.SECONDS.convert(elapsedInNanos, TimeUnit.NANOSECONDS);