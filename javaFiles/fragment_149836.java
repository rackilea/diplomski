WebElement ele = driver.findElement(By.id("btn1"));     
Actions builder = new Actions(driver);
builder.clickAndHold(ele);
// Any other actions you want to build onto this
// eg. builder.moveToElement(ele)
//        .release(ele)
//        .etc...
// Now build and get the Action
Action action = builder.build();
// Perform the action(s)
action.perform();
// Take your screenshot
// Build the release action
builder = new Actions(driver);
builder.release(ele);
// Get the built action and perform
action = builder.build();
action.perform();