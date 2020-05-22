public enum MyEnum {
    Emails("mail1", "mail2", "mail3"), 
    Usernames("username1", "username2"), 
    CategoryN("a", "b", "c");

    private String[] strings;

    private MyEnum(String... strings) {
        this.strings = strings;
    }

    @Override
    public String toString() {
        return Arrays.toString(strings);
    }

    public String getString(int index) {
        return strings[index];
    }

}