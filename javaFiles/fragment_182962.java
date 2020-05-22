public class HtmlUnitTest {             
    public static void main(String[] args) {
        HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_38);
        driver.setJavascriptEnabled(true);
        String baseUrl = "h t t p s : / / fourseasons . wd3 . myworkdayjobs . com / search / jobs";
        driver.get(baseUrl);
        WebDriverWait myWaitVar = new WebDriverWait(driver, 20);
        try{
            myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("wd-FacetedSearchResult-ResultsPnl-facetSearchResult")));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        String content=driver.getPageSource();
        System.out.println(content);
        driver.close();         
    }      
}