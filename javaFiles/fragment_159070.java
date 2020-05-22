@RunWith(PowerMockRunner.class)
@PrepareForTest({ClassUnderTest.class, Bicycle.class})
public class ConstructorMockingTest
{
    @Test
    public void getBicycle()
    {
        ClassUnderTest tested = new ClassUnderTest();
        whenNew(Bicycle.class).withArguments(tested).thenThrow(new RemoteException());

        Bicycle bicycle = tested.getBicycle();

        assertNull(bicycle);
    }
}