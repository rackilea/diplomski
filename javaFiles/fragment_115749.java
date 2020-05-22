Dimension windowSize = driver.manage().window().getSize();
Map<String, Object> args = new HashMap<>();
args.put("command", "input");
args.put("args", Lists.newArrayList("swipe", windowSize.width / 2,
        windowSize.height / 2, windowSize.width / 2, windowSize.height));
while (driver.findElements(By.xpath("//android.widget.TextView[@text='1998']")).size() == 0) {
    driver.executeScript("mobile: shell", args);
}
driver.findElement(By.xpath("//android.widget.TextView[@text='1998']")).click();