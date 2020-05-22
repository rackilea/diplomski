String title =driver.getTitle();
System.out.println("Page title is:" + title);

String expectedTitle = "LinkedIn: Log In or Sign Up";

    if (title.contains(expectedTitle))
        {
            System.out.println("Test Passed!");
        }
    else  
        {
            System.out.println("Test Failed");
        }