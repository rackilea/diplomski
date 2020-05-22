System.setOut(new PrintStream(new OutputStream(){

    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        calculation.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        calculation.setCaretPosition(calculation.getDocument().getLength());
    }

}));