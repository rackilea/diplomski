public void isCalendarVisible() {
    try {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
        return true;
    } catch (TimeOutException e) {
        return false;
}