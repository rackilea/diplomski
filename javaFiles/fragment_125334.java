try{
   //Wait 10 seconds till alert is present
   WebDriverWait wait = new WebDriverWait(driver, 10);
   Alert alert = wait.until(ExpectedConditions.alertIsPresent());

   //Accepting alert.
   alert.accept();
   System.out.println("Accepted the alert successfully.");
}catch(Throwable e){
   System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
}