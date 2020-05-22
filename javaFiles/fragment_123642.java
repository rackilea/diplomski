WebElement buyNowButton = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Buy Now'][position()=2]")));

boolean clicked = false;
int attempts = 0;
while (!clicked && attempts < 5000) {
    try {
        actionMoveAndClick(buyNowButton);
        clicked = true;
    } catch (Exception e) {
        System.out.println("Unable click on 'BuyNow' button | clickOnBuyNowButton()");
        Assert.fail("Method failed: waitAndClickElement");
    }
    attempts++;
}