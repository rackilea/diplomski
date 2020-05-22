@Test
public void isApiPresent_returns_true_on_Win8()
{
    assumeTrue(System.getProperty("os.version").equals("6.2"));
    assertTrue(isApiPresent());
}
@Test
public void isApiPresent_returns_false_on_Win7()
{
    assumeTrue(System.getProperty("os.version").equals("6.1"));
    assertFalse(isApiPresent());
}