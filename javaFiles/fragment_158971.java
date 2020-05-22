System.setProperty("log_path", my_log_path);

//Reload:
LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
ContextInitializer ci = new ContextInitializer(lc);
lc.reset();
try {
  //I prefer autoConfig() over JoranConfigurator.doConfigure() so I wouldn't need to find the file myself.
  ci.autoConfig(); 
} catch (JoranException e) {
  // StatusPrinter will try to log this
  e.printStackTrace();
}
StatusPrinter.printInCaseOfErrorsOrWarnings(lc);