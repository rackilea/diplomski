CustomLogging logger = CustomLogging.getLogger(MyClassNameHere.class);

try{
   logger.info("print in log");
}finally{
   logger.shutdown();
}