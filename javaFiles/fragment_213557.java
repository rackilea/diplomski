static class CUT {
    void close(Closeable _close) {
        try {
            _close.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

@Test
public void test() throws Exception {
    Closeable spyCloseable = Mockito.spy(new Closeable() {
        @Override
        public void close() throws IOException {
            throw new IOException("dummy");
        }
    });
    Exception blob = null;
    try {
        new CUT().close(spyCloseable);
        fail("should have thrown");
    } catch (Exception e) {
        blob = e;
    }
    assertThat(blob.getMessage(), is("java.io.IOException: dummy"));
}