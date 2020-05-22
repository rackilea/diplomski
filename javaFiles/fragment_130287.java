public static void slowmotionUp(InternetExplorerDriver driver) throws Exception {
        for (int second = 0;; second++) {
            if(second >=60){
                break;
            }
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(1000,-13)", "");
        }
    }