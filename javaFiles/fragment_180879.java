File dir = new File("DownloadPath");
String partialName = downloaded_report.split("_")[0].concat("_"); //get cancelled and add underscore
FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.pollingEvery(1, TimeUnit.SECONDS);
        wait.withTimeout(15, TimeUnit.SECONDS);
        wait.until(x -> {
            File[] filesInDir = dir.listFiles();
            for (File fileInDir : filesInDir) {
                if (fileInDir.getName().startsWith(partialName)) {
                    return true;
                }
            }
            return false;
        });