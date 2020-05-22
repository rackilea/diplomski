Class Example {
    public static final int ITEM_APPLE = 0;
    public static final int ITEM_BANANA = 1;
    public static final int ITEM_GRAPE = 3;

    private static final Map<String, Integer> fruitCodes = new HashMap<String, Integer>();

    static {
        fruitCodes.put("apple", ITEM_APPLE);
        fruitCodes.put("banana", ITEM_BANANA);
        // ...
    }


    public void incomingData(String value) {
        // Possible values would be "apple", "banana", and "grape" in this case.
        Integer code = fruitCodes(value);

        if (null == code) {
            throw new IllegalArgumentException("Forbidden fruit: " + value);
        }
    }
}