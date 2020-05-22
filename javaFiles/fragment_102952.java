List<WebElement> elementList = driver.findElements(By.cssSelector("ul.numbers.diaDeSorte#ulDezenas li"));
ArrayList<String> values = new  ArrayList<>();
for(WebElement element:elementList)
    values.add(element.getText());
System.out.println(values.stream().
                map(Object::toString).
                collect(Collectors.joining(" ")).toString());