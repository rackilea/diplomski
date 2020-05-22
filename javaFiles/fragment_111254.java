List<WebElement> element = driver.findElements(By.cssSelector("tr"));

        int row = 0;

        for( WebElement w : element){

            String elemText = w.getText();

            System.out.println(elemText);

            String clickText = "Spinning 90 min";

            if(elemText.contains(clickText)){

                w.click(); //do something with the element

                System.out.println("Text in row " + row + " is " + clickText + " so i clicked it!");
            }

            System.out.println("this was row " + row + "\n");

            row++;
        }