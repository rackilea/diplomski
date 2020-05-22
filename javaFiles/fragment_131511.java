public enum Id implements Identifiable {
    FOO,
    BAR;

    @Override
    public String getId() {
        return name();
    }
}