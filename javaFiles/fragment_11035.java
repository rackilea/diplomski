public enum MyEnum {
    FIRST(0L), SECOND(1L), THIRD(2L);

    private Long number;

    /**
     * Lookup map, to provide a quick way to access your enums by id
     */
    private static final Map<Long, MyEnum> LOOKUP = new HashMap<Long, MyEnum>();

    /**
     * Static initializer, which loads your enums values runtime, and maps them
     * to their 'number' member.
     */
    static {
        MyEnum[] enums = MyEnum.class.getEnumConstants();
        for(MyEnum en : enums){
            LOOKUP.put(en.number, en);
        }
    }

    private MyEnum(final Long number) {
        this.number = number;
    }

    /**
     * Gets the enum value associated with the parameter, id.
     * @param id The id, that identifies your enum value
     * @return The enum value, or null, if not found.
     */
    public static MyEnum getById(final Long id){
        return LOOKUP.get(id);
    }
}