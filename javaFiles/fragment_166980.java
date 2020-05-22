public static enum Tipo {
    ENTRATA("Entrata", 1),
    USCITA("Uscita", 2);

    private String string;
    private int integer;

    private Tipo(String string, int integer) {
        this.string = string;
        this.integer = integer;
    }
}