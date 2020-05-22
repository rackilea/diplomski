ExecutorService executor = Executors.newFixedThreadPool(5);

executor.submit(() -> compareCSV(f1, f2));
executor.submit(() -> compareCSV(f3, f4));
executor.submit(() -> compareCSV(f5, f6));
executor.submit(() -> compareCSV(f7, f8));