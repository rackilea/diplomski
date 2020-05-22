String script = "var callback = arguments[arguments.length - 1];" + //the last argument is the callback function
                "var classToCall = 'SeleniumTest.IsPageReloaded';" +  //the classname you want to return to call from Java in case of success)
                "window.addEventListener('onload', callback(classToCall));"; 
//you can give any supported return value to the callback function. Here I assume that you want to call a static method. This is the class name that can be used later.
try {
    JavascriptExecutor js = (JavascriptExecutor)driver;
    //classToCall has the value we passed to the callback function
    String classToCall = js.executeAsyncScript(script);
} catch (ScriptTimeoutException e) {
    System.err.println("Uhhh... this failed I guess");
    e.printStackTrace();
}