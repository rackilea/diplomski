public static void main(String[] args){
    Logger log=Logger.getLogger("myLogger");

    Logger logA = LogManager.getLogManager().getLogger("myLogger"); //exists
    Logger logB = LogManager.getLogManager().getLogger("nonExistantLogger"); //is null

}