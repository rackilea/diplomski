class PagesFactory{
    private WebDriver driver;

    public HomePage getHomePage(){
         return new HomePage( driver );
    }

    // if you want to share the same object (singleton) among many tests

    private SecondPage secondPage;
    public SecondPage getSecondPage(){
         if( secondPage == null ){
              secondPage = new SecondPage( driver );
         }
         return secondPage( driver );
    }
    .....
    .....
}