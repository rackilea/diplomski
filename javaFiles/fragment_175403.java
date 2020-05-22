try{
  // Wait for the start of the cycle:
  barrier.wait(); //remove this, you never called notify so its useless

  //business logic omitted

  // Wait until every cell is done calculating its new value:
  barrier.await();

  // And then actually update the values of the cells
  value += increment;
}catch(Exception ex){
  System.err.println("Exception occurred! " + ex);
  ex.printStackTrace();
}