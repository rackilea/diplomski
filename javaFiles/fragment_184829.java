@RunWith(PowerMockRunner.class)
@PrepareForTest(First.class)
public class StackOverflowTest {

    @Test
    public void testFirst() throws Exception {
        Second secondMock = EasyMock.createMock(Second.class);
        PowerMock.expectNew(Second.class).andReturn(secondMock);
        expect(secondMock.doSecond()).andReturn("Mocked!!!");
        PowerMock.replay(secondMock, Second.class);
        String actual = new First().doSecond();
        PowerMock.verify(secondMock, Second.class);
        assertThat(actual, equalTo("Mocked!!!"));
    }

}