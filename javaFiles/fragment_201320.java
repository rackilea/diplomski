public void checkDate(){

    String currentDate = null;
    int counter=0;

    WebElement tab = driver.findElement(By.id("tabid"));

    List<WebElement> rows= tab.findElements(By.tagName("tr"));

    for(int i =0;i<=rows.size()-1;i++){



        List<WebElement> columns=rows.get(i).findElements(By.tagName("td"));
        Iterator itr = columns.iterator();


        while(itr.hasNext()){

            WebElement we=(WebElement) itr.next();

            if(we.getText().equals(currentDate)){

                break;

            }

            counter=counter+1;
        }

    //element to be clicked is +1 to c

        driver.findElement(By.cssSelector("tr:nth-child(i) li:nth-child(counter+1)")).click();

    }