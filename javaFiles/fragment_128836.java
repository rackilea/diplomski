import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

    public void testUpload() throws InterruptedException
        {
            WebElement element = driver.findElement(By.name("uploadfilebutton"));
//can use By cssSelector or name (path) as per convenience
            element.click();
            uploadFile("path to the file");
            Thread.sleep(2000);
        }

        /**
         * This method will set any parameter string to the system's clipboard.
         */
        public static void setClipboardData(String string) {
            //StringSelection is a class that can be used for copy and paste operations.
               StringSelection stringSelection = new StringSelection(string);
               Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            }

        public static void uploadFile(String fileLocation) {
            try {
                //Setting clipboard with file location
                setClipboardData(fileLocation);
                //native key strokes for CTRL, V and ENTER keys
                Robot robot = new Robot();

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }