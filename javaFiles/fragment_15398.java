WebDriverWait tempWait = new WebDriverWait(driver, 10); // define local/temp wait only for the "sleep"
try {
    tempWait.until(ExpectedCondition); // condition you are certain won't be true
}
catch (TimeoutException) {
    continue; // catch the exception and continue the code
}
// continue the code