public void Check_for_text_in_column(String text, String row, String column)
{
    By by = By.xpath("//*[@id=\"table_Table_table_ktg\"]/tbody/tr[" + row + "]/td[" + column + "]/div/div/span");
    WebDriverWait wait = new WebDriverWait(getWebDriver(), WAIT_TIME);

    // your original find
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    // flag to set when text is found, for exiting loop
    boolean hasText = false;

    // counter for # of times to loop, finally timing out
    int tries = 0;

    // until text is found or loop has executed however many times...
    while (hasText == false && tries < 20) {

        // get the element
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        // if text is not present, wait 250 millis before trying again
        if(!element.getText().equals(text){
            Thread.sleep(250);
            tries++;
        }
        else{
            // text found, so set flag to exit loop
            hasText = true;
        }   
    }


    if(!element.getText().equals(text))
    {
        fail("\nDid not find text: " + text + "\nFound text: " + element.getText() + "\n");
    }
}