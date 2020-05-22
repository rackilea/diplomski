public class PhoneNumberValidatorTest extends TestCase {

    public void testValidator() {
        assertTrue("Valid number 1", PhoneClass.phoneNumberValidator("123456789"));
        assertTrue("Valid number 2", PhoneClass.phoneNumberValidator("000000000"));
        assertFalse("Invalid input 1", PhoneClass.phoneNumberValidator("0"));
        assertFalse("Invalid input 2", PhoneClass.phoneNumberValidator("abcdefghi"));
    }

    public void testPasser() {
        // Test with a valid input
        System.setIn(new ByteArrayInputStream("123456789".getBytes()));
        assertEquals("123456789", PhoneClass.passPhoneNumber());

        // Test with another valid input
        System.setIn(new ByteArrayInputStream("000000000".getBytes()));
        assertEquals("000000000", PhoneClass.passPhoneNumber());

        // Test with 1 invalid inputs and then 1 valid input
        System.setIn(new ByteArrayInputStream("0\n111222333".getBytes()));
        assertEquals("111222333", PhoneClass.passPhoneNumber());

        // Test with 2 invalid inputs and then 1 valid input
        System.setIn(new ByteArrayInputStream("abcdefghi\n12346578\n122333444".getBytes()));
        assertEquals("122333444", PhoneClass.passPhoneNumber());

        // Reset to the original System.in
        System.setIn(System.in);
    }
}