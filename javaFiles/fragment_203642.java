public String determineIfCorrectUrlOnPopUp() {

clickOnEmailThisSeller();

// Below Line in your code will switch to  the current window  by using for each loop
for (String currentWindow: driver.getWindowHandles())
       driver.switchTo().window(currentWindow);
{
   //Now you are in Popup window and you can get the pop-up window URL here
    System.out.println(driver.getCurrentUrl());
    driver.close();  
}

System.out.println(driver.getCurrentUrl()); // This will return Parent window URL
return driver.getCurrentUrl();

}