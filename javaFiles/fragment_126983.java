public class CloserTest {

    @Test
    public void allReadersClosedWhenOneReaderThrowsException() {
        // given
        Reader badReader = mock(Reader.class);
        Reader secondReader = mock(Reader.class);
        doThrow(new IOException()).when(badReader).close();
        Closer closer = new Closer(badReader, secondReader);

        // when
        closer.close();

        // then
        verify(badReader).close();
        verify(secondReader).close(); // fails as loop stops on first exception
    }
}