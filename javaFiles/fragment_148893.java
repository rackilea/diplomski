String title =driver.getTitle();
title = title.replaceAll("&"+"nbsp;", " "); 
title = title.replaceAll(String.valueOf((char) 160), " ");
System.out.println("Page title is:" + title);

String expectedTitle = "LinkedIn: Log In or Sign Up";

    if (title.trim().equalsIgnoreCase(expectedTitle))
        {
            System.out.println("Test Passed!");
        }
    else  
        {
            System.out.println("Test Failed");
        }