Stream.of(1, 2).parallel()
      .peek(x -> System.out.println("processing "+x+" in "+Thread.currentThread()))
      .map(x -> {
           LockSupport.parkNanos("simulated workload", TimeUnit.SECONDS.toNanos(3));
           return x;
        })
      .forEach(System.out::println);