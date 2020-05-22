public class Rahul {

    String downloadDir = "C:\\Users\\pburgr\\Downloads\\";

    public WebDriverWait waitSec(WebDriver driver, int sec) {
        return new WebDriverWait(driver, sec);
    }

    public File waitToDownloadFile(WebDriver driver, int sec, String fileName) {
        String filePath = downloadDir + fileName;
        waitSec(driver, 30).until(new Function<WebDriver, Boolean>() {
          public Boolean apply(WebDriver driver) {
            if (Files.exists(Paths.get(filePath))) {
              System.out.println("Downloading " + filePath + " finished.");
              return true;
            } else {
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                 System.out.println("Downloading " + filePath + " not finished yet.");
              }
            }
            return false;
          }
        });
        File downloadedFile = new File(filePath);
        return downloadedFile;
      }
}