if (once) {
  for (MSLiteThread thread : Threads) {
     System.out.println("created thread");
     thread = new MSLiteThread(pile);
     thread.start();
  }
once = false;
}