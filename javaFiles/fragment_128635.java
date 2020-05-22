static final Properties prop = new Properties();
static {
    try{
        prop.load(new FileInputStream("db.properties"));
    }catch(Exception e){
        logger.info("file not found.");
        e.printStackTrace();
    }
}