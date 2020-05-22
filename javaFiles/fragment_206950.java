By byCss = By.cssSelector(".item-box>div input[value='Add to cart']");
int cartCount = driver.findElements(byCss).size();

if (cartCount != 4){
    //fail the test
}