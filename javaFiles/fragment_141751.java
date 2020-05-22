// this is all inside of the loop with the executorService created outside of loop
List<Future<?>> futures = new ArrayList<>();
for (File inputFile : inputDir.listFiles()) {   
    if (inputFile.isFile())     
         futures.add(executorService.submit(new MyRunnable(inputFile)));      
    }
}
// now we go back and wait for the jobs to finish
for (Future<?> future : futures) {
    // this waits for each job to finish
    // it throws some exceptions that you'll need to catch and handle
    future.get();
}