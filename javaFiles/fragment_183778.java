package com.stackoverflow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author maba, 2012-09-25
 */
public class SimpleTest {

    @Test
    public void testConfigValue() {
        assertEquals("stackoverflow", Config.FOO_BAR);
    }
}