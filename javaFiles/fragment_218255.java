public static void main(String[] args) {
    Logger X = Logger.getLogger("com.foo");
    try {
        X.addAppender(new FileAppender(new PatternLayout("%d %-5p [%c{1}] %m%n"),"src/test.log"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    X.debug("Hello World debug message");
}