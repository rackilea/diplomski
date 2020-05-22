try {

  driver.findElement(By.id("com.simplemobiletools.gallery:id/dir_thumbnail")).click();             
  driver.findElement(By.id("com.simplemobiletools.gallery:id/medium_thumbnail")).click();
catch (Exception e) {
  driver.findElement(By.id("com.offerup:id/circle")).click(); 
  driver.findElement(By.id("com.offerup:id/done")).click();
}