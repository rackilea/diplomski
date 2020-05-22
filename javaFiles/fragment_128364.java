public enum Type {
    LABORATORY("Laboratory"), //This one is not working
    OFFICE,
    COMPUTER_LAB,
    LECTURE_ROOM,
    HALL;

    private final String val;

    Type() {
        this.val = "";
    }

    Type(String val) {
        this.val = val;
    }
}