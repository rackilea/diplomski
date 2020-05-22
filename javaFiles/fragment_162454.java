public class EnumResolverTest {

    @Test
    public void testSignalEnum() {
        EnumResolver signalResolver = new EnumResolver("com.abc.SignalEnum");
        assertEquals(SignalEnum.RED, signalResolver.resolve("1"));
        assertEquals(SignalEnum.GREEN, signalResolver.resolve("2"));
        assertEquals(SignalEnum.ORANGE, signalResolver.resolve("3"));
    }

    @Test
    public void testMobileEnum() {
        EnumResolver mobileResolver = new EnumResolver("com.abc.MobileEnum");
        assertEquals(MobileEnum.SAMSUNG, mobileResolver.resolve("1"));
        assertEquals(MobileEnum.NOKIA, mobileResolver.resolve("2"));
        assertEquals(MobileEnum.APPLE, mobileResolver.resolve("3"));
    }
}