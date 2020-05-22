String pizzaType = "Hawaiian"; // the pizza type from the Pizza menu
String postcode = "AL1 2PS";
String url = "https://www.pizzahut.co.uk/";
driver.get(url);
driver.findElement(By.linkText("Pizza")).click(); // click Pizza menu
driver.findElement(By.xpath("//h3[text()='" + pizzaType + "']/../../../..//button")).click(); // click a pizza type specified by pizzaType
driver.findElement(By.id("ajax-postcode-txt")).sendKeys(postcode); // enter a postcode
driver.findElement(By.id("get-store-btn")).click(); // click "Find a Hut"
driver.findElement(By.cssSelector("input[data-value='later']")).click(); // click "Order for later"