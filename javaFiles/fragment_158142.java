int i=0;
String links[]= new String[10];
links[0]="link1";
links[1]="link2";
links[2]="link3";
links[3]="link4";
WebDriver driver = new FirefoxDriver();

while(i<4){
    try { 
        driver.get(links[i]);
        driver.findElement(By.xpath("//div[contains(@id,'image')]")).click();
        i++;
    }
    catch(NoSuchElementException e){
        System.out.println(links[i] + " failed");
        i++;
    }
}