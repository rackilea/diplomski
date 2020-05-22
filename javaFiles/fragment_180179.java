public void someMethod() {
    Config config = null;
    try {
        config = new Config();
    } catch (IOException e) { 
        // handle it
    } catch (ExcFormattingError e) {
        // handle it
    }
}