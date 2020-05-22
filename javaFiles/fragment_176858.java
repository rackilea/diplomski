public class NumberRadixTests {

    @Test
    public void testRadixDetection() {
        assertEquals(16, RadixDetector.detectRadix("0xabcd"));
        assertEquals(16, RadixDetector.detectRadix("0xABCD"));
        assertEquals(16, RadixDetector.detectRadix("0xAFFF"));
        assertEquals(16, RadixDetector.detectRadix("0x0"));
        assertEquals(16, RadixDetector.detectRadix("0X0"));
        assertEquals(16, RadixDetector.detectRadix("0XFFF"));
        assertEquals(8, RadixDetector.detectRadix("0123"));
        assertEquals(8, RadixDetector.detectRadix("011"));
        assertEquals(8, RadixDetector.detectRadix("0777"));
        assertEquals(8, RadixDetector.detectRadix("0666"));
    }

    @Test
    public void testHexRegex() {
        assertTrue(RadixDetector.isValidHex("0xabcd"));
        assertTrue(RadixDetector.isValidHex("0Xabcd"));
        assertTrue(RadixDetector.isValidHex("0xAbcd"));
        assertTrue(RadixDetector.isValidHex("0xa0cd"));
        assertTrue(RadixDetector.isValidHex("0x9bc1"));
        assertTrue(RadixDetector.isValidHex("0x9bc1"));
        assertFalse(RadixDetector.isValidHex("x9bc1"));
        assertFalse(RadixDetector.isValidHex("0xbtc1"));
        assertFalse(RadixDetector.isValidHex("0xx9bc1"));
        assertFalse(RadixDetector.isValidHex("00x9bc1"));
        assertFalse(RadixDetector.isValidHex("0x9pc1"));
        assertFalse(RadixDetector.isValidHex("0x"));
        assertFalse(RadixDetector.isValidHex("077"));
    }

    @Test
    public void testOctalRegex() {
        assertTrue(RadixDetector.isValidOctal("077"));
        assertTrue(RadixDetector.isValidOctal("067"));
        assertTrue(RadixDetector.isValidOctal("07777"));
        assertTrue(RadixDetector.isValidOctal("017"));
        assertFalse(RadixDetector.isValidOctal("08"));
        assertFalse(RadixDetector.isValidOctal("8"));
        assertFalse(RadixDetector.isValidOctal("777"));
        assertFalse(RadixDetector.isValidOctal("0x"));
        assertFalse(RadixDetector.isValidOctal("08"));
        assertFalse(RadixDetector.isValidOctal("01238"));
    }

}