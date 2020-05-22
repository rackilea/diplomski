driver.findElement(By.id("datepicker")).click();//to click on thedate picker field
    String date_ent = "17-May-2017";
    String date_ent1[] = date_ent.split("-");
    String shipFDay = date_ent1[0];
    String shipFMonth = date_ent1[1];
    String shipFYear = date_ent1[2];
 String date_pres = driver.findElement(By.xpath("//th[@title='Select Month']")).getText();
 System.out.println(date_pres);
    String dp[] = date_pres.split(" ");
    String month_pres = dp[0];
    String year_pres = dp[1];
    if (year_pres.equals(shipFYear)) {
        driver.findElement(By.xpath("//th[@title='Select Month']")).click();

        driver.findElement(By.xpath("//span[contains(.,'" + shipFMonth + "')]")).click();
        Thread.sleep(5000);

    } else if (Integer.parseInt(year_pres) > Integer.parseInt(shipFYear)) {
        driver.findElement(By.xpath("//th[@title='Select Month']")).click();

        while (2 > 1) {
            year_pres = driver.findElement(By.xpath("//th[@title='Select Year']")).getText();
            if (year_pres.equalsIgnoreCase(shipFYear)) {

                driver.findElement(By.xpath("//span[contains(.,'" + shipFMonth + "')]")).click();
                Thread.sleep(5000);
                break;
            }
            driver.findElement(By.xpath("//span[@title='Previous Year']")).click();
        }

    } else {
        driver.findElement(By.xpath("//th[@title='Select Month']")).click();
        while (2 > 1) {
            year_pres = driver.findElement(By.xpath("//th[@title='Select Year']")).getText();
            if (year_pres.equalsIgnoreCase(shipFYear)) {

                driver.findElement(By.xpath("//span[contains(.,'" + shipFMonth + "')]")).click();

                Thread.sleep(5000);
                break;
            }
            driver.findElement(By.xpath("//span[@title='Next Year']")).click();
        }
    }

    switch (shipFMonth) {
    case "Jan": {
        driver.findElement(By.xpath("//td[@data-day='01/" + shipFDay + "/" + shipFYear + "']")).click();
        System.out.println("Date Selected");
        break;
    }

    case "Feb": {
        driver.findElement(By.xpath("//td[@data-day='02/" + shipFDay + "/" + shipFYear + "']")).click();
        System.out.println("Date Selected");
        break;
    }
    case "Mar": {
        driver.findElement(By.xpath("//td[@data-day='03/" + shipFDay + "/" + shipFYear + "']")).click();
        System.out.println("Date Selected");
        break;
    }
    case "Apr": {
        driver.findElement(By.xpath("//td[@data-day='04/" + shipFDay + "/" + shipFYear + "']")).click();
        System.out.println("Date Selected");
        break;
    }
    case "May": {
        driver.findElement(By.xpath("//td[@data-day='05/" + shipFDay + "/" + shipFYear + "']")).click();
        System.out.println("Date Selected");
        break;
    }
    case "Jun": {
        driver.findElement(By.xpath("//td[@data-day='06/" + shipFDay + "/" + shipFYear + "']")).click();
        System.out.println("Date Selected");
        break;
    }
    case "Jul": {
        driver.findElement(By.xpath("//td[@data-day='07/" + shipFDay + "/" + shipFYear + "']")).click();
        System.out.println("Date Selected");
        break;
    }
    case "Aug": {
        driver.findElement(By.xpath("//td[@data-day='08/" + shipFDay + "/" + shipFYear + "']")).click();
        System.out.println("Date Selected");
        break;
    }
    case "Sep": {
        driver.findElement(By.xpath("//td[@data-day='09/" + shipFDay + "/" + shipFYear + "']")).click();
        System.out.println("Date Selected");
        break;
    }
    case "Oct": {
        driver.findElement(By.xpath("//td[@data-day='10/" + shipFDay + "/" + shipFYear + "']")).click();
        System.out.println("Date Selected");
        break;
    }
    case "Nov": {
        driver.findElement(By.xpath("//td[@data-day='11/" + shipFDay + "/" + shipFYear + "']")).click();
        System.out.println("Date Selected");
        break;
    }
    case "Dec": {
        driver.findElement(By.xpath("//td[@data-day='12/" + shipFDay + "/" + shipFYear + "']")).click();
        System.out.println("Date Selected");
        break;
    }
    default: {
        System.out.println("Please enter the date in the standard format like DD-MMM-yyyy");
     break;
    }
    }