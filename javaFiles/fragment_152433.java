@Override
public void run() {
   System.out.println("Started "+this.getName());
   try {
       WebDriver driver = new HtmlUnitDriver(true);
       driver.get("http://google.com");
       //System.out.println(driver.getCurrentUrl());
       driver.findElement(By.tagName("html"));
       driver.quit();
   } catch (Throwable e) {
       System.err.println(this.getName() + " " +e.getMessage());
   }
   System.out.println("Finished "+this.getName());
}