@Test
public void testAction() throws IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
        CmdLineException, IOException {

        // Setup WriterAppender
        Writer w = new StringWriter();
        Layout l = new PatternLayout("%m%n");

        WriterAppender wa = new WriterAppender(l, w);
        wa.setEncoding("UTF-8");
        wa.setThreshold(Level.ALL);
        wa.activateOptions();// WriterAppender does nothing here, but I like defensive code...

        // Add it to logger
        Logger log = Logger.getLogger(ExceptionHandler.class);// ExceptionHandler is the class that contains this code : `log.warn("An error has occured:", e);'
        log.addAppender(wa);

        try {
             // Call to the method that will print text to STDOUT...

             String batchLog = w.toString();
             assertTrue("Invalid exception text !", batchLog.contains("my expected text..."));
        } finally {
             // Cleanup everything...
             log.removeAppender(wa);
             wa.close();
        }
}