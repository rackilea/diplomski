public Map<Boolean, List<String>> getHrefResponseBoolean() {

        WebDriver driver = new FirefoxDriver();
        return driver.findElements(By.xpath("//*[not('svg' = substring(@href,string-length(@href) -string-length('svg') +1)) " + 
                "    and" + 
                "    not('webmanifest' = substring(@href,string-length(@href) -string-length('webmanifest') +1))" + 
                "    and" + 
                "    not('ico?v=2' = substring(@href,string-length(@href) -string-length('ico?v=2') +1))" + 
                "]"))
                .stream()
                .map(ele -> ele.getAttribute("href").trim())
                .distinct()
                .collect(Collectors.partitioningBy(link -> getResponseCode(link) == 200));

  }