public static String[] threadedSort(File[] files) throws IOException, InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(files.length);
        List<Future<String[]>> futureList = new ArrayList<>();
        String[] sortedData = null;
        for (int i=0; i<files.length; i++) {
            futureList.add(executor.submit(new SortingThread(files[i])));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);

        for (Future<String[]> future :futureList) {
        String[] values = future.get();
        // merge values and  finalData to create one array.
      }
      return finalData;
    }