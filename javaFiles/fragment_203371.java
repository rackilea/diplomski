String thisWindow = driver.getWindowHandle();
Set<String> windowHandles = driver.getWindowHandles();
for (String windowHandle : windowHandles) {
    if (!windowHandle.contains(thisWindow)) {
        driver.switchTo().window(windowHandle);
    }
}