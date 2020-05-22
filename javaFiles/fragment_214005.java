enum Command {
    KILL {
        @Override public void execute(String arg) {
            System.out.printf("%s is dying...", arg)
        }
    },
    KISS {
        @Override public void execute(String arg) {
            System.out.printf("I'm kissing %s!", arg)
        }
    };

    public abstract void execute(String arg);
}