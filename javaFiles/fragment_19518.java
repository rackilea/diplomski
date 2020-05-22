package com.stackoverflow.questions52609313.test;

import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestCase;

public class GwtMapsTestSuite extends TestCase {
    public static Test suite() {
        GWTTestSuite suite = new GWTTestSuite("Test for a Maps Application");
        suite.addTestSuite(MainTestGwt.class);
        return suite;
    }
}