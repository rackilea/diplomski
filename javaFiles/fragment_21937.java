class NoLookingBack{
    CountDownLatch latchB = new CountDownLatch(1);


    public void methodA(){
      //do work.
      latchB.countDown();
    }

    public void methodB(){
        try{
            latchB.await();
        } catch(InterruptException e){
            //do something or declare this method throws.
            return;
        }
    }
}