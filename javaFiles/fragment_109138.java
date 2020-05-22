CountDownLatch countDownLatch = new CountDownLatch(fixedNumber);

private  void testSuitLogin(String driverType){

  try{
    System.out.println(Thread.currentThread().getName()+" Start Time "+System.currentTimeMillis());
    driver = WebDriverFactory.getDriver(driverType);
    countDownLatch.countDown();  // decreases the value of latch by 1 in each call.
    countDownLatch.await();      //It will wait until value of the latch reaches zero.
    System.out.println(Thread.currentThread().getName()+" End Time "+System.currentTimeMillis());
    homePage();
    googleSignIn();
    driver.quit();
  }
  catch(Exception e){
    if(driver==null)
    {
      countDownLatch.countDown();
      totalNumberOfUsers--;
      return ;
    }
  }
}