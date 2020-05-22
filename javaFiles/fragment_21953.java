ExecutorService executor = Executors.newFixedThreadPool(3);

for (int i = 1; i <= 1000; i++) {
      final int counter = i;
      executor.execute(new Runnable() {
          @Override
          public void run() {
              outFile.write(wld.getWord(counter) + "successful");
              outFile.write("\n");
          }               
      });
}

executor.shutdown(); //shut down executor
executor.awaitTermination(60, TimeUnit.SECONDS); //waiting for 60 seconds

outFile.close(); //and then you may safely close the stream knowing that all the tasks have finished