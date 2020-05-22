public ProgramLog() {

      try {
         FileHandler handler = new FileHandler(logFile);
         logger = Logger.getLogger("com.program.msgs");
         logger.addHandler(handler);

      } catch (Exception e) {
      }
   }