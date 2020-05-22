public void selectDate(WebDriver driver, String format){
    //1) Initialize variables
    String curr[] = getCurrentDate("dd/MM/yyyy").split("/");
    String req[] = format.split("/");

    int currDate = Integer.parseInt(curr[0]);
    int reqDate = Integer.parseInt(req[0]);

    int currMonth = Integer.parseInt(curr[1]);
    int reqMonth = Integer.parseInt(req[1]);

    int currYr = Integer.parseInt(curr[2]);
    int reqYr = Integer.parseInt(req[2]);

    //2) Select required year
    if (currYr > reqYr){
        for (int i=0;i<(currYr-reqYr);i++){
            //decrease year
            driver.findElement(By.linkText(" «")).click();
        }   
    } else if (currYr < reqYr){
        for (int j=0;j<(reqYr-currYr);j++){
            //increase year
            driver.findElement(By.linkText("» ")).click();
        }
    }

    //3) Select required month
    if (currMonth > reqMonth){
        for (int i=0;i<(currMonth-reqMonth);i++){
            //decrease month
            driver.findElement(By.linkText("‹ ")).click();
        }
    } else if (currMonth < reqMonth){
        for (int j=0;j<(reqMonth-currMonth);j++){
            // increase month
            driver.findElement(By.linkText(" ›")).click();
        }
    }

    //4) Select required date
    driver.findElement(By.linkText(String.valueOf(reqDate))).click();
}

public static String getCurrentDate(String format)
{
    Calendar cal = Calendar.getInstance();
    Date date = cal.getTime();
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    return sdf.format(date);
}