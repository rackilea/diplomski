String url = "http://www.example.com"; // the first page of the product list page
driver.get(url);
List<WebElement> next;
while (true)
{
    // wait for and get all the product links
    WebDriverWait wait = new WebDriverWait(driver, 10);
    List<WebElement> productLinks = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Produto")));
    // loop through the product links
    for (WebElement productLink : productLinks)
    {
        driver.get(productLink.getAttribute("href")); // navigate to product page
        // do stuff on product page
    }

    // now we're done with all products on this page, go back to the product list page that we were last on
    driver.get(url);

    // look for a Next link
    next = driver.findElements(By.cssSelector("li.next"));
    if (next.isEmpty())
    {
        // Next link DOES NOT exist, exit loop
        break;
    }

    // Next link DOES exists, click it to go to the next page
    next.get(0).click();
    // may need to wait for page transition here
    url = driver.getCurrentUrl(); // store the current product list page