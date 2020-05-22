public Course {
    private String cName;
    public Course(String name) {
        cName = name; // Using "this" is no longer required,
                      // because names are different.
    }
}