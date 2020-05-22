@When("^navigate to ([^\"]*) page$")
public void navigate_to_page(String page) throws Throwable 
{
    System.out.println(page);
    driver.get(page);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
}

@Then("^check ([^\"]*) of the page$")
public void check_title_of_the_page(String title) throws Throwable 
{
    System.out.println(title);
    if(driver.getTitle().equalsIgnoreCase(title))
    {
        System.out.println("Verified title of : "+title);
    }
}