@RunWith(PowerMockRunner.class)
@PrepareForTest({EvilBase.class, NicerSingleton.class})
public class TestEvil {

    @Test
    public void testEvil() {
        suppress(constructor(EvilBase.class));
        assertEquals(69, EvilBase.getInstance().theMethod());
    }

    @Test public void testNice() {
        suppress(constructor(EvilBase.class));
        suppress(constructor(NicerSingleton.class));
        assertEquals(42, NicerSingleton.getInstance().theMethod());
    }

}