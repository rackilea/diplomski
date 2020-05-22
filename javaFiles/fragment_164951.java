String title=""; //initially keep title empty
    //will automatically be called after click on an element
    public void afterClickOn(WebElement element, WebDriver driver) {

            //title is not equal to previous page title

            if(driver.getTitle()!=title){

            //take screenshot

            //assign the current title to string title
            title=driver.getTitle();

            }

        }