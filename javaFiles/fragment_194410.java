public enum BoxLocation{
    ROOM("ROOM","in room", "Room box"),
    BUILDING("BUILDING","in building"),
    STREET("STREET","in street", "Street box"),
    STANDARD("STANDARD","in house"),
    BIG_ROOM("BIG ROOM", "in big room");

    private final List<String> values;

    BoxLocation(String ...values) {
        this.values = Arrays.asList(values);
    }
    public List<String> getValues() {
        return values;
    }
    public static String find(String name) {
        for (BoxLocation bl : BoxLocation.values()) {
            if (bl.getValues().contains(name)) {
                return bl.values.get(0);
            }
        }
        return BoxLocation.STANDARD.values.get(0);
    }
}