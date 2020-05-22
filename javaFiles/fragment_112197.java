driver.get("https://www.stagecoachbus.com/regionaltickets/yorkshire/rotherham/megarider");

// close the Please set your location popup
driver.findElement(By.cssSelector("#location-overlay > a.close-icon.js-close-overlay")).click();

String desiredTicketName = "22X 7 day megarider"; // read this from sheet
System.out.println("Looking for: " + desiredTicketName);
WebDriverWait wait = new WebDriverWait(driver, 10);
List<WebElement> ticketContainers = wait
        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='cf']")));
for (WebElement ticketContainer : ticketContainers)
{
    List<WebElement> h3s = ticketContainer.findElements(By.tagName("h3"));
    String currentTicketName = h3s.get(0).getText();
    String currentPurchaseLocation = h3s.get(1).getText();
    if (currentTicketName.contains(desiredTicketName) && currentPurchaseLocation.contains("Smart - online"))
    {
        // found the ticket and it's sold online

        // click Add to basket
        ticketContainer.findElement(By.cssSelector("a.submit-btn")).click();

        // click Close
        wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(ticketContainer, By.cssSelector("a.close-icon"))).get(0)
                .click();

        break;
    }
}