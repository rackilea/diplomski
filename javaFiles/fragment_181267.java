String command = "click";
String id = "id";

Method byMethod = By.class.getMethod(id, String.class);
WebElement element = driver.findElement((By) byMethod.invoke(null, "id1"));

Method method = WebElement.class.getMethod(command);
method.invoke(element);