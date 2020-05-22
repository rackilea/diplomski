private static Logger getLogger(){
    if(logger == null){
        try {
            new MyLogging();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return logger;
}
public static void log(Level level, String msg){
    getLogger().log(level, msg);
    System.out.println(msg);
}