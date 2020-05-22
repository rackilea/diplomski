driver.get("https://media.giphy.com/media/l49JL8rJ2vOEXlmM0/giphy.gif");
driver.find_by_css_selector('a._3X9Zhs_atixoQRBDsNGQnl > img').sendKeys(Keys.CONTROL+ "c");

driver.get("https://paste.pics/");
Actions action = new Actions(driver); 

action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();