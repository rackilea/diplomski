iAttempts = 0;
while (iAttempts < 5) {
    try {
        oList1 = new Select(dev.findElement(By.id("tool1")));
        break;
    } catch (StaleElementReferenceException e) {
    }
    iAttempts++;
}