public void startFileLog(String fileName){
        FileAppender fa = new FileAppender();
        fa.setName(fileName);
        fa.setFile(fileName+".log");
        fa.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
        fa.setThreshold(Level.DEBUG);
        fa.setAppend(true);
        fa.activateOptions();
        //add appender to any Logger (here is NOT root)

        Logger.getLogger(fileName).setAdditivity(false); // messages will not go to root logger anymore!
        Logger.getLogger(fileName).addAppender(fa);
        //repeat with all other desired appenders
    }