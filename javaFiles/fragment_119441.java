private static final String USERNAME = "^[a-zA-Z0-9_]{6,32}$";
private static final String PASSWORD = "^[a-zA-Z]\w{5,17}$";
private static final String EMAIL = "^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$";

@Pattern(regexp = USERNAME)
private String name;

...