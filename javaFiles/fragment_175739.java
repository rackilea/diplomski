ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("--user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.2840.100 Safari/537.36");
    driver = new ChromeDriver(chromeOptions);
    chromeDriver.get("https://institucional.xpi.com.br/investimentos/fundos-de-investimento/lista-de-fundos-de-investimento.aspx");
    List<WebElement> elements = chromeDriver.findElement(By.xpath("//*[@id=\"tableTodos\"]")).findElements(By.tagName("tr"));
    System.out.println(elements.get(200).getText());