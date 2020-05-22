// acquire text
if (acquire.equals("congratulations")) {
    sendMail("Something, tada badum tss!");
} else {
    driver.findElement(By.id("myButton")).click();
}