package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configreader {

    // make property as static
    public static Properties pro;

    // make method as static
    public static void ConfigFileReader() 
      {
             try {
                  File src = new File("./src/test/resources/config.properties");
                  FileInputStream fis = new  FileInputStream(src);
                  pro = new Properties();
                  pro.load(fis);
                  System.out.println("Property class loaded");
              } 
              catch (Exception e) {
                  System.out.println("Exception is" +e.getMessage());
              }
      }
}

package com.example;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoanDetails extends Configreader {

    @BeforeTest
    public  void beforetest() throws Exception { 
       // Called this method in before test annotation method  
        ConfigFileReader();    
        //  driver = Browser.GetBrowser();
        System.out.println(pro.getProperty("account_path"));
                driver.findElement(By.xpath(pro.getProperty("account_xpath"))).click();
    }

    @Test
    void testmain() {
        System.out.println("Testng test");
    }
}