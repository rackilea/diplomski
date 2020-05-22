try {
    click(myButton);
} catch (UnhandledAlertException f) {
    try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert data: " + alertText);
        alert.accept();
    } catch (NoAlertPresentException e) {
        e.printStackTrace();
    }
}