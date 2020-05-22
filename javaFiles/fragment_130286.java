public static void slowmotionDown(InternetExplorerDriver driver) throws Exception {
        for (int second = 0;; second++) {
            if(second >=60){
                break;
            }
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,13)", "");
        }
    }