Print_icon.click();

for (String winHandle : driver.getWindowHandles()) {
    driver.switchTo().window(winHandle);
}

boolean elmnt = false;
boolean timeOut = false;
int second = 1;
do {
    try {
        if(second>30) {
            timeOut = true;
        }
        Cancel_button.click();
        elmnt=true;
    } catch (Exception e) {
        TimeUnit.SECONDS.sleep(1);
        second++;
    }
}while(elmnt==false && timeOut==false);