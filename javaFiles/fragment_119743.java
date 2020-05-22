class Name{
    public static final String FULL_NAME_DELIMITER = " ";
    public static final String PRINT_DELIMITER = ", ";

    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static String[] getName(String fullName){
        return fullName.split(FULL_NAME_DELIMITER);
    }

    public String getLastName(){
        return this.lastName;
    }

    @Override
    public String toString(){
        return String.join(PRINT_DELIMITER , this.lastName, this.firstName);
    }

    public void print(){
        System.out.println(this);
    }
}