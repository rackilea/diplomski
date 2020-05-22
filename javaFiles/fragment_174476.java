public class WorkingWithThumbNails {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://www.carsguide.com.au/car-reviews/toyota-tarago-used-review-1990-2015-41984");

    // Now count the number of images in the thumb-nails cause
    // this will decide number of clicks on the next Arrow

    List<WebElement> myThumbnails = driver.findElements(By.cssSelector(".rsTmb.lazyload"));
    List<WebElement> myMainImages = driver.findElements(By.cssSelector(".rsImg.rsMainSlideImage"));

    System.out.println("Size of the thumbnail is : " + myThumbnails.size());
    System.out.println("Size of the main image is : " + myMainImages.size());


    // print the urls of the thumb-nails as well
    for(int i=0;i< myThumbnails.size();i++){
        myThumbnails = driver.findElements(By.cssSelector(".rsTmb.lazyload"));
        System.out.println("Url for the Thumbnail is : " + myThumbnails.get(i).getAttribute("src"));

        myMainImages = driver.findElements(By.cssSelector(".rsImg.rsMainSlideImage"));
        System.out.println("Url for the main image is : " + myMainImages.get(i).getAttribute("src"));

        // now implement the logic of img verification, logic can be many but here i used if src for bigger img 
        // contains img name as per the thumbnail img name then its ok img is properly loaded and hence it is right image.

        String[] myMainImgName = myMainImages.get(i).getAttribute("src").split("s3");

        if(myThumbnails.get(i).getAttribute("src").contains(myMainImgName[1])){
            System.out.println("Main image is as per the thumbnail.");
            // to verify next thumb-nail img with main img we have to click
            // here if is because loop will run one more time then img size
            if(driver.findElements(By.xpath("//*[@class='rsArrow rsArrowRight']/div")).size() > 0){
                driver.findElement(By.xpath("//*[@class='rsArrow rsArrowRight']/div")).click();
            }
        }else{
            // apply the same logic for videos 
            // hope you can do this 
        }
    }

}