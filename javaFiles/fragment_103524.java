List<WebElement> linkElements = driver.findElements(By.xpath("//a[@class='my_img']"));
System.out.println("The number of links under URL is: "+linkElements.size());

//Getting all the 'href' attributes from the 'a' tag and putting into the String array linkhrefs
String[] linkhrefs = new String[linkElements.size()];
int j = 0;
for (WebElement e : linkElements) {
    linkhrefs[j] = e.getAttribute("href");
    j++;
}

// test each link
int k=0;
for (String t : linkhrefs) {
    try{
        if (t != null && !t.isEmpty()) {
            System.out.println("Navigating to link number "+(++k)+": '"+t+"'");
            driver.navigate().to(t);
            String title;
            title = driver.getTitle();
            System.out.println("title is: "+title);

            //Some known errors, if and when, found in the navigated to page.
            if((title.contains("You are not authorized to view this page"))||(title.contains("Page not found"))
                            ||(title.contains("503 Service Unavailable"))
                            ||(title.contains("Problem loading page")))
            {
            System.err.println(t + " the link is not working because title is: "+title);
            } else {
                System.out.println("\"" + t + "\"" + " is working.");
            }
        }else{
            System.err.println("Link's href is null.");
        }
    }catch(Throwable e){

        System.err.println("Error came while navigating to link: "+t+". Error message: "+e.getMessage());
    }

    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
}