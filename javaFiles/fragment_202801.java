try {
    frameworkMethod();
} catch (FrameworkException ex) {
    logger.log(Level.SEVERE, "An exception occured!", ex);

    if (ex instanceof IllegalDataException) {
        // Do something to recover
    } else if (ex instanceof InvalidCommandException) {
        //Inform the user
    } //And so on...
}