JTextArea txtrExecutionStatus = new JTextArea();
...
OutputStream textAreaOut = new OutputStream() {
    private ByteArrayOutputStream lineBuffer = new ByteArrayOutputStream();

    @Override
    public void write(int b) {
        lineBuffer.write(b);
    }

    @Override
    public void flush() {
        byte[] bytes = lineBuffer.toByteArray();
        lineBuffer.reset();
        String line = new String(bytes); // Default OS encoding.
        txtrExecutionStatus.append(line);
    }
}

PrintStream redirect = new PrintStream(textAreaOut, true);
System.setOut(redirect);