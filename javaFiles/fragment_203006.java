public enum SQL {
    TABLE("TABLE", SQL.CREATE_FLAG | SQL.ALTER_FLAG),
    DATABASE("DATABASE", SQL.CREATE_FLAG);

    public static final int CREATE_FLAG = 1;
    public static final int ALTER_FLAG = 2;

    public static final String CREATE_STRING = "CREATE";
    public static final String ALTER_STRING = "ALTER";

    public static final String INVALID = "INVALID";

    private String name;
    private boolean create;
    private boolean alter;

    SQL(String name, int flags) {
        create = (flags & CREATE_FLAG) != 0;
        alter = (flags & ALTER_FLAG) != 0;

        this.name = name;
    }

    public String create() {
        if (create)
            return CREATE_STRING + " " + name;
        else
            return INVALID;
    }

    public String alter() {
        if (alter)
            return ALTER_STRING + " " + name;
        else
            return INVALID;
    }
}