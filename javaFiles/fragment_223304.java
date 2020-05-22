package com.secondClasses.A;

import com.classes.B;

public class B {

A test1;
Webdriver driver;
String url2;

@BeforeClass
public static void Log(){
//some code here to check if log is ok
}

@Before
public void setUp() {
    driver = new WebDriver();
    test1 = new A(driver);
}

@After
public void cleanUp() {
    driver = null;
    test1 = null;
    url2 = null;
    System.gc();
}

@Test
public void A(){
    url2 = test1.getUrl();
    assertTrue(url2.equals(url));
}