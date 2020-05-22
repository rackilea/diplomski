@Mock Writer writer;

@InjectMock MyService sut;

@Captor ArgumentCaptor<List<Data>> captor;

@Test
public void testSave() {
    List<InputData> input = ...
    sut.callMethod(input);

    // check that write() was called on the writer
    verify(writer).write(captor.capture());
    // retrieve the value it was called with
    List<Data> saved = captor.getValue();
    // do some more validation on the data if necessary
}