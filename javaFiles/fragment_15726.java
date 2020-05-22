@Test
public void exampleTest(@Mocked AFinalClass mock)
{
    // Call the code under test which uses AFinalClass.

    new Verifications() {{ AFinalClass.someStaticMethod(); }};
}