if(valueFound) {
    driver.findElement(By.xpath("//*[@id='LogonModel_OrganisationName']")).sendKeys(forceID);
    driver.findElement(By.xpath("//*[@id='LogonModel_UserId']")).sendKeys(username);
    driver.findElement(By.xpath("//*[@id='LogonModel_Password']")).sendKeys(password);
    driver.findElement(By.xpath("//*[@id='maincontent']/form/div/fieldset/div[4]/div[2]/input")).click();
} else {
    //dont login
}