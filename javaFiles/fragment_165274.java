Context ctx  = new InitialContext();
   Context envCtx = (Context)ctx.lookup("java:comp/env");
   String propertiesFileLocation = (String) envCtx.lookup("propertiesfilelocation");
   LOGGER.info("String property === " + propertiesFileLocation);

   properties.load(new FileInputStream(propertiesFileLocation));