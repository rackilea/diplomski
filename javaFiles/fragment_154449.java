package regressionTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.*;
import org.openqa.selenium.By.ByXPath;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDBConnect {

public static String username = null;

    @BeforeClass
    public void setUp() {
        username = getUsernameFromDB();
    }

    @Test
    public void testUI() {

        //Some code for navigating to the required page
        driver.findElement(By.id("u")).sendKeys(username);
        //Code for executing remaining steps 

    }

    public static String getUsernameFromDB() throws ClassNotFoundException, SQLException  {
            //Accessing driver from the JAR file 
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Oracle JDBC driver loaded ok.");

            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@151.117.87.205:1602:epwfst1","epwf_app","epwf_app_epwfst1");
            System.out.println("DB Connected Successfuly");

            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery("select billing_application_accnt_id from epwf.payment where created_user_nm = '1600STOUTST10001'");

            String account = null;       
            while(result.next()){
                account = result.getString("BILLING_APPLICATION_ACCNT_ID");
                System.out.println("BAID: " + account);
            }
            con.close();
            return account;
         }
   @AfterClass
   public void cleanUp() {
          //Code for clean-up activities like closing browser and releasing resources.
   }
}