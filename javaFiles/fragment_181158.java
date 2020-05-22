WebElement we = driver.findElement(By.tagName("div"));
JavascriptExecutor executor = (JavascriptExecutor)driver;
String script = "var s = '';" +
                "var o = getComputedStyle(arguments[0]);" +
                "for(var i = 0; i < o.length; i++){" +
                "s+=o[i] + ':' + o.getPropertyValue(o[i])+';';}" + 
                "return s;";

System.out.println(executor.executeScript(script, we));