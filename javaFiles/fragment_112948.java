private static org.apache.log4j.Logger logger;

public static Logger getLogger(){
    if(logger == null){
        logger= LogManager.getLogger(ClassName.class);
        DOMConfigurator.configure("path/to/log4jxml");
    }
    return logger;

}