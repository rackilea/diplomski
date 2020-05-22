package de.scrum_master.app;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testAdd() {
        assertEquals(33, Calculator.add(11, 22));
        assertEquals(12, Calculator.add( 4,  8));
        assertEquals(11, Calculator.add(11,  0));
    }

    @Test
    public void testSubtract() {
        assertEquals(33, Calculator.subtract(44, 11));
        assertEquals(12, Calculator.subtract(12,  0));
        assertEquals(11, Calculator.subtract(19,  8));
    }

    @Test
    public void testMultiply() {
        assertEquals(33, Calculator.multiply( 3, 11));
        assertEquals(12, Calculator.multiply( 4,  3));
        // This assertion should fail
        assertEquals(11, Calculator.subtract(10,  5));
    }

    @Test
    public void testDivide() {
        assertEquals(33, Calculator.divide(99, 3));
        assertEquals(12, Calculator.divide(51, 4));
        // This call should cause an exception
        assertEquals(11, Calculator.divide(11, 0));
    }
}