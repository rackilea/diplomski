public final class Config { 
    public final int CONST_1;
    public final String CONST_2;

    public Config(File file) throws IOException {
        try (Scanner s = new Scanner(file)) {
            CONST_1 = s.nextInt();
            CONST_2 = s.next();
        } 
    }
}