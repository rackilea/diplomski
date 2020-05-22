WebDriverWait wait = new WebDriverWait(driver, 30);wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.gallery:id/grid")));
 driver.context("NATIVE_APP");
 HashMap<String, Double> map = new HashMap<String, Double>();
 map.put("x", 0.3);
 map.put("y", 0.3);
 (driver).executeScript("mobile: tap", map);