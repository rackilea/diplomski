public final class Config { 
    public static final int CONST_1;
    public static final String CONST_2;

    static {
        int c1;
        String c2;
        try (Scanner s = new Scanner(new File("config.txt"))) {
            c1 = s.nextInt();
            c2 = s.next();
        } catch (IOException ex) {
            throw RuntimeException("Cannot load config properties", ex);
        }
        CONST_1 = c1;
        CONST_2 = c2; 
    }
}