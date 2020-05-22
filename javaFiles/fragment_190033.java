public class WebTableToTxtFile {
    static WebDriver driver = new FirefoxDriver();

    public static void main(String[] args) throws Throwable   {
        driver.navigate().to("http://www.bloomberg.com/markets/stocks/futures");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement table = driver.findElement(By.cssSelector
                ("div[class='data-tables first']"));

        List<WebElement> irow = table.findElements
                (By.cssSelector("div[class='data-tables first'] tr"));
        System.out.println("No. of rows in the table are: " + irow.size());

        File txtFile = new File
                ("MyFileLocation/Output.txt");
        StringBuilder sb = new StringBuilder();

        for(int r=0; r<irow.size(); r++) {
            WebElement webRow = irow.get(r);
            System.out.print(webRow.getText());

            List<WebElement> allCells = webRow.findElements(By.xpath("th | td"));

            for(int c=0; c<allCells.size(); c++) {
                WebElement webCell = allCells.get(c);
                String text = webCell.getText();
                System.out.print(text);
                sb.append(text + '\n');
            }

            System.out.println("");

        }

        FileWriter fw = new FileWriter(txtFile.getAbsolutePath());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(sb.toString());
        bw.close();

        end();
    }
    public static void end() {
        driver.close();
        driver.quit();
    }
}