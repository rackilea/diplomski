try{


    WebDriverWait customWait = new WebDriverWait(driver, 2); //2 is for seconds before timingout

    customWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("PegaGadget0Ifr")));


} catch(Exception e){
    System.out.println(e.toString());
}