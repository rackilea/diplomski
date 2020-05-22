try {
  for (int count = 1; count <= 10; count++)
  {
     Thread.sleep(generator.nextInt(3000)); // random sleep
     // ...
  }
} catch (InterruptedException exception) {
  Thread.currentThread().interupt(); 
}