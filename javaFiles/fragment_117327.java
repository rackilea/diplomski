String color = driver.findElement(By.xpath("//div[@class='gb_e gb_f gb_g gb_xb']/a")).getCssValue("color");
String[] numbers = color.replace("rgb(", "").replace(")", "").split(",");
int r = Integer.parseInt(numbers[0].trim());
int g = Integer.parseInt(numbers[1].trim());
int b = Integer.parseInt(numbers[2].trim());
System.out.println("r: " + r + "g: " + g + "b: " + b);
String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
System.out.println(hex);