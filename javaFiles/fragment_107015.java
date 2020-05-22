Logger jdbcLogger = LogManager.getContext(false).getLogger("JDBC_Logger"); 
jdbcLogger.info(new StringMapMessage()
    .with("eventId", AuditEventType.Logger_General.toString())
    .with("exception", "")
    .with("userId", "TESTUSER")
    .with("message", "TEST!!")
    .with("className", 
        this.getClass().getPackage().toString().replaceAll("package ", "") 
        + "." + this.getClass().getSimpleName() 
        + "." + new Object() {}.getClass().getEnclosingMethod().getName())
);