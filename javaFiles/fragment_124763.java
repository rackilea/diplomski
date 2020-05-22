public enum Items {

    COW("text", 0),
    CAT("abc", 1),
    DOG("wow", 2),
    // ...
    ;

    private final String textString;
    private final int number;

    private Item(String textString, int number) {
        this.textString = textString;
        this.number = number;
    }

    public void search(String search) {
        for(Item : values()) {
            if("abc".equals(item.textString)) {
                //DO SOMETHING
            }
        }
    }
}