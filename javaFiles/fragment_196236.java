public boolean isElementPresent(By element) {
   try {
       driver.findElement(element);
       return true;
   } catch (NoSuchElementException e) {
       return false;
   }
}