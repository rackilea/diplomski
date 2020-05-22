public void resetLogs() {

    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory(); 
    ContextInitializer ci = new ContextInitializer(lc); 
    lc.reset();
    try {   
        ci.autoConfig();  
    } catch (JoranException e) {  
        e.printStackTrace(); 
    }
}