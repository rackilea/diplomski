public static void main(String[] args) 
{
     WebDriver  driver = new FirefoxDriver();
     driver.get("http://www.freepdfconvert.com/");
     driver.findElement(By.id("UploadedFile")).sendKeys("C:\\Users\\Reputa\\Downloads\\HP1.pdf");        
     try {
            Thread.sleep(4000);
        } catch (Exception e) {}
     driver.findElement(By.name("pdfsubmit")).click();
        }