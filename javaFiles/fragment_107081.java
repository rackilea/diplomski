// WARNING! Untested code written from memory without
// benefit of an IDE! May not be exactly correct!

// Switch the driver context to the alert
Alert alertDialog = driver.switchTo().alert();

// Get the alert text
String alertText = alertDialog.getText();

// Click the OK button on the alert.
alertDialog.accept();