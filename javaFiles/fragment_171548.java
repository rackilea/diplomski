...
Set<String> handles = driver.getWindowHandles();
for (String windowHandle : handles) {
     subWindowHandler = windowHandle;
}
if(subWindowHandler != null && !subWindowHandler.equals(parentWindowHandler) {
    driver.switchTo().window(subWindowHandler);
    driver.close();
    driver.switchTo().window(parentWindowHandler);
}
...