package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class Googletest {
    private Selenium selenium;

    @Before
    public void setUp() throws Exception {
        selenium = new DefaultSelenium("localhost", 4444, "*chrome", "https://www.google.com/");
        selenium.start();
    }

    @Test
    public void testGoogletest() throws Exception {
        selenium.open("/");
        selenium.type("//div[@id='gs_lc0']/input", "type some random text");
        selenium.click("//div[@id='gbqfbw']/button");
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}