StringConverter<Sector> converter = new StringConverter<Sector>() {
    @Override
    public String toString(Sector object) {
        return object.getTitle();
    }

    @Override
    public Sector fromString(String string) {
        return null;
    }
};