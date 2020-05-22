public void login(){

    driver.switchTo().frame(0);
    driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[2]/form/fieldset/div[1]/input")).sendKeys("abcde");//("admin");
    driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/fieldset/div[2]/input")).sendKeys("password");
    driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/fieldset/div[3]/label/input")).click();
    driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/fieldset/input")).click();
}