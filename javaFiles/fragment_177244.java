//select barge
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddl_commodity"))).selectByVisibleText("Jo");

    String sDate = "12/04/2014"; //What date you want
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txt_rate")).sendKeys(sDate);

    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btn_show")).click();
    Thread.sleep(3000);

    WebElement findElement = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1"));
    String htmlTableText = findElement.getText();
    // do whatever you want now, This is raw table values.
    System.out.println(htmlTableText);