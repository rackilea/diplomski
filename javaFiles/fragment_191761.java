package com.example.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class IJ_ApplyForJob {

 IJ_Login login = new IJ_Login();

@Test
public void SFJ_HomeSearchBoxNotLoggedIn(WebDriver driver)
{
    driver.findElement(By.id("kwdInput")).clear();
    driver.findElement(By.id("kwdInput")).sendKeys("Testing");
    //find the dropdown and search for the location dublin
    Select ddSelectLoc = new Select(driver.findElement(By.name("Location")));
    ddSelectLoc.selectByVisibleText("Dublin");
    //find the dropdown and search for the Category IT
    Select ddSelectCat = new Select(driver.findElement(By.id("home-category")));
    ddSelectCat.selectByVisibleText("IT");
    //click search button and search for term.
    driver.findElement(By.className("btn-search")).click();
    //click first job title
    driver.findElement(By.id("ctl00_ctl00_cphMain_cphMain_ucJobs_rptResult_ctl02_hlTitle")).click();
    //click apply for job
    driver.findElement(By.className("ApplyForJobButton")).click();
    //complete form
    driver.findElement(By.id("ctl00_ctl00_cphMain_cphMain_ucApplyJob_txtComments")).clear();
    driver.findElement(By.id("ctl00_ctl00_cphMain_cphMain_ucApplyJob_txtComments")).sendKeys("Cover Letter Testing");
    driver.findElement(By.id("ctl00_ctl00_cphMain_cphMain_ucApplyJob_txtFirstName")).clear();
    driver.findElement(By.id("ctl00_ctl00_cphMain_cphMain_ucApplyJob_txtFirstName")).sendKeys("Test");
    driver.findElement(By.id("ctl00_ctl00_cphMain_cphMain_ucApplyJob_txtSecondName")).clear();
    driver.findElement(By.id("ctl00_ctl00_cphMain_cphMain_ucApplyJob_txtSecondName")).sendKeys("Test");
    driver.findElement(By.id("ctl00_ctl00_cphMain_cphMain_ucApplyJob_txtPhone")).clear();    
    driver.findElement(By.id("ctl00_ctl00_cphMain_cphMain_ucApplyJob_txtPhone")).sendKeys("12345678");
       driver.findElement(By.id("ctl00_ctl00_cphMain_cphMain_ucApplyJob_txtEmail")).clear();
    driver.findElement(By.id("ctl00_ctl00_cphMain_cphMain_ucApplyJob_txtEmail")).sendKeys("craig.mccarthy@live.ie");
   // Upload CV not logged in
    driver.findElement(By.id("ctl00_ctl00_cphMain_cphMain_ucApplyJob_fileCV")).sendKeys("C:\\Users\\Craig\\Desktop\\CV_TEST.docx");
    //wait for CV to upload
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    //submit application
    driver.findElement(By.id("ctl00_ctl00_cphMain_cphMain_ucApplyJob_btnSubmit")).click();
}