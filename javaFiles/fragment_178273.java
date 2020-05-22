public class FixedNow{

    @Test
    public void fixedNow() {

        MyDao mockedDao = mock(MyDao.class);
        BOProcessor mockedProcessor = mock(BOProcessor.class);
        FakeBusinessObject problematicBO = new FakeBusinessObject();
        ArgumentCaptor<FakeBusinessObject> fakeBOCaptor = ArgumentCaptor.forClass(FakeBusinessObject.class);

        MyDaoService classUnderTest = new MyDaoService(mockedDao, mockedProcessor);

        doThrow(new Exception()).when(mockedProcessor).process(eq(problematicBO));
        doNothing().when(mockedProcessor).process(fakeBOCaptor.capture());

        classUnderTest.interactWithDao();

        assertThings(BOCaptor.getValue());
    }
}