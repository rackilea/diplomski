final long start = System.nanoTime();
counter.countPrimes(1000000);
final long end = System.nanoTime();

System.out.println("Took: " + ((end - start) / 1000000) + "ms");
System.out.println("Took: " + (end - start)/ 1000000000 + " seconds");