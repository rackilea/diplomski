@Test public void doLogin() throws InterruptedException{

        // Login and navigate to frineds tab
        driver.get(config.getProperty("URL"));
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys(config.getProperty("Login"));
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(config.getProperty("Password"));
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(Keys.RETURN);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@title='Profile']")).click();

        //find your frineds count
        String frinedsCount = driver.findElement(By.xpath("//*[@data-tab-key='friends']")).getText().substring(7);
        int count = Integer.parseInt(frinedsCount);

        //click on frineds tab
        driver.findElement(By.xpath("//*[@data-tab-key='friends']")).click();

        //find your couurent loaded frineds count and get it in a list
        List<WebElement> frineds = driver.findElements(By.xpath("//*[@class='fsl fwb fcb']"));
        int found = frineds.size();


        while (found <= count){

            //scroll to the last friend found from the current loaded friend list
            Coordinates coordinate = ((Locatable) frineds.get(found-1)).getCoordinates();
            coordinate.onPage();
            coordinate.inViewPort();
            frineds = driver.findElements(By.xpath("//*[@class='fsl fwb fcb']"));
            found = frineds.size();

            // break and print frined list if the condition found frineds = count of frined list
            if (found == count){
                System.out.println(found);
                System.out.println("---Printing FriendList---");
                for (int i=0; i<found; i++){
                System.out.println(frineds.get(i).getText());
                }
                break;
            }

        }
    }