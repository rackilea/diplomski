int DESIRED_COUNT = 100;
int currentCount = driver.findElements(By.cssSelector("#films .film")).size();

while (currentCount < DESIRED_COUNT) {
    driver.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    Thread.sleep(1000);
    currentCount = driver.findElements(By.cssSelector("#films .film")).size();
}

// now get the page source
System.out.println(driver.getPageSource());