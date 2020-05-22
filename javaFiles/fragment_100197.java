public class CaptureScreenShot {
                private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");

                public static String captureScreen(WebDriver driver, String screenName) throws IOException{

                    TakesScreenshot screen = (TakesScreenshot) driver;
                    File src = screen.getScreenshotAs(OutputType.FILE);

                    String dest ="C:/xampp//htdocs/Automation_report/Test-ScreenShots"+screenName+".png";

                    File target = new File(dest);
                    FileUtils.copyFile(src, target);

                    return dest;
                }

                public static String generateFileName(ITestResult result){
                    Date date = new Date();
                    String fileName = result.getName()+ "_" + dateFormat.format(date);
                    return fileName;

                }
            }