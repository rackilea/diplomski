@Test
    public void testWriteToOutputStreamExceptionHandling() {
        //Dummy object for testing
        OutputStream exceptionThrowingOutputStream = new OutputStream() {
            public void write(byte[] b) throws IOException {
                throw new IOException(); //always throw exception
            }
            public void write(int b) {} //need to overwrite abstract method
        };

        try {
            YourClass.writeToOutputStream(new byte[0], exceptionThrowingOutputStream);
            fail("NetModelStreamingException expected");
        }
        catch (NetModelStreamingException e) {
            //ok
        }
    }