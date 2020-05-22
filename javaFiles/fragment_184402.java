Actions actions = new Actions(driver);

// create the mouserover action
Action mouseOverOnElement = actions.moveToElement(linkMenu).build();

// get the back ground color before mouse over             
String bgColor = linkMenu.getCssValue("background-color");
System.out.println("Before hover: " + bgColor);

// perform the mouseover operation        
mouseOverOnElement.perform();    

// get the back ground color after mouse over       
bgColor = linkMenu.getCssValue("background-color");
System.out.println("After hover: " + bgColor);