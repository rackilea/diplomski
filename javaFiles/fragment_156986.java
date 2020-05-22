public void avaSizes(){
    Select select = new Select(driver.findElement(By.id("product_sizes"))); 
    // Find all the available shoe sizes for each randomly selected product
    List<WebElement> avaSizes = select.getOptions(); 
    int totalSizes = 0;
    for(WebElement size:avaSizes){
        if(size.isEnabled()==true){
            System.out.println(size.getText());
            totalSizes++;
            }else{
                System.out.println("Out of stock in " + size.getText());
                }
        }
    System.out.println("This product is available in: " + totalSizes + " sizes.");
}