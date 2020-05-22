public class MyLogClass {

 private static Logger log =  Logger.getLogger(MyLogClass.class);
 private static boolean initFlag = false;

 private static void initLogger(){
   log.setLevel(Level.DEBUG);

   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
   Date date = new Date();

   RollingFileAppender appender = new RollingFileAppender();
   appender.setAppend(true);
   appender.setMaxFileSize("1MB");
   appender.setMaxBackupIndex(1);
   appender.setFile("my_log_file-" + dateFormat.format(date) + ".log");

   PatternLayout layOut = new PatternLayout();
   layOut.setConversionPattern(PatternLayout.SIMPLE_CONVERSION_PATTERN);
   appender.setLayout(layOut);

  log.addAppender(appender);
 }

 public static Logger getLogger(){
   if(initFlag == false){
      initLogger();
      initFlag = true;
      return MyLogClass.log;
   } else {
      return MyLogClass.log;
   }
 }
}