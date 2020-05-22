@Test
public void grablinks() {

    String hrefvalue = null;

    driver.get("https://www.amazon.com");

    List<WebElement> links = driver.findElements(By.tagName("a"));
    for (int i = 0; i<links.size(); i++)
    {
        hrefvalue = links.get(i).getAttribute("href");

        if(hrefvalue != null){
            if(hrefvalue.contains("amazon"))
            {
               System.out.println( hrefvalue + " = internal domain");
            }
            else
            {
               System.out.println( hrefvalue + " = external domain");
            }
        }else{
              System.out.println("element doesn't have href attriubte");
       }
    }

}