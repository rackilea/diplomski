List<WebElement> email = driver.findElements(By.cssSelector("div.xT>div.y6>span>b"));

for(WebElement emailsub : email){
    if(emailsub.getText().equals("Your Subject Here") == true){

           emailsub.click();
           break;
        }
    }