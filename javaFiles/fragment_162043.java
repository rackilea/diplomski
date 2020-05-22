public TestGUI() throws IOException{
      initComponents();
      private final CountDownLatch latch = new CountDownLatch(1);
      Item.importItems(progressBar, latch); // static method that execute a new thread to import item witouth freeze my UI (I update a progressBar in it)
      latch.await();
      table.refresh(); //Metodh that I need to execute only after "importItems()" methods is completed
}