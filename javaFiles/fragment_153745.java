JavascriptExecutor js = (JavascriptExecutor) driver;

// set the value (note how the arguments are passed into)
js.executeScript("window.myvar = arguments[0];", "Test");

// get the value (note the "return")
String myvar = (String) js.executeScript("return window.myvar;");
System.out.println(myvar);