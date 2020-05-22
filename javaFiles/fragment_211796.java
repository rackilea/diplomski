public void contextInitialized(ServletContextEvent contextEvent) {
    Nutans_Mongo.setNameOFDB("someDBNAME"); //then intialize MongoDBCLass
    MongoDBClass.INSTANCE.getSomeDB().getCollection("UserDB");
    System.out.println("Context Created");//This is working
    context = contextEvent.getServletContext();
    context.getServerInfo();
    MongoDBClass.INSTANCE.getSomeDB().getCollection("UserDB");//Server loading and unable to start .
    }