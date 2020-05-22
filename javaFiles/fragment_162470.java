String cssLocator=.... 
JavascriptExecutor js = (JavascriptExecutor) driver;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("var x = $(\'"+cssLocator+"\');");
        stringBuilder.append("x.click();");
        js.executeScript(stringBuilder.toString());