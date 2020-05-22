List<WebElement> elementList = driver.findElements(By.cssSelector("ul.numbers.diaDeSorte#ulDezenas li"));
ArrayList<String> values = new  ArrayList<>();
for(WebElement element:elementList)
    values.add(element.getText());
StringJoiner joiner = new StringJoiner(" ");
for (String item : values)
    joiner.add(item.toString());
System.out.println(joiner.toString());