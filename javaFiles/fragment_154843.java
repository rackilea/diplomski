// Navigate to QA Environment to begin test
driver.get("https://qa-safari-develop.browzine.com/libraries/14/subjects");

// Allow search for elements to wait for page(s) to load
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//** Getting the ul with the links
WebElement subjectElems = driver.findElement(By.xpath("//*[@id=\"subjects-list\"]"));

  // looking for an element with link text = Biomedical and Health Sciences
   WebElement biomedicalAndHealthSciences = subjectElems.findElement(By.linkText("Biomedical and Health Sciences"));

System.out.println(biomedicalAndHealthSciences.getText());
// Click on the subject Biomedical and Health Sciences from the Browse Subjects Navigation
biomedicalAndHealthSciences.click();