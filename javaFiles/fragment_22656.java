combo.setConverter(new StringConverter<AirPort>() {

    @Override
    public String toString(AirPort object) {
        return object.getName();
    }

    @Override
    public AirPort fromString(String string) {
        return combo.getItems().stream().filter(ap -> 
            ap.getName().equals(string)).findFirst().orElse(null);
    }
});