private OutputStream exceptionThrowingOutputStream;

@Before
public void setUp() throws Exception {
    exceptionThrowingOutputStream = new OutputStream() {
        @Override
        public void write(byte[] b) throws IOException {
            throw new IOException();
        }
        @Override
        public void write(int b) {}
    };
}

@Test(expected = NetModelStreamingException.class)
public void testWriteToOutputStreamExceptionHandling() throws NetModelStreamingException {
    YourClass.writeToOutputStream(new byte[0], exceptionThrowingOutputStream);
}