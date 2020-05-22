Alert alert = null;
try {
    alert = wait.until(ExpectedConditions.alertIsPresent());
catch(Exception) { }

if(alert == null) {
    System.out.println("alert was not present")
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/button[2]"))).click();
    Confirmation.click();
}
else {
    String Recipemessage = alert.getText();
    System.out.println(Recipemessage);

    if (Recipemessage.equals(alertmessage2) || Recipemessage.equals(alertmessage4)) {
        Thread.sleep(3000);
        alert.accept();
        break;
    }
}