driver.get("http://auticon.nepomedia-staging.de/");

//get all links with href that start with http
ArrayList<String> links = (ArrayList) ((JavascriptExecutor) driver).executeScript("return [...document.querySelectorAll(\"a[href^='http']\")].map(e=>e.getAttribute('href'))");

links.forEach(link->{
    driver.get(link);
    //check here
});