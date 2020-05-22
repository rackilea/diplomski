public enum EnumTest{
    ITEMONE ("The 1st option"),
    ITEMTWO ("The 2nd option"),
    ITEMTHREE ("The 3rd option");

    private final String message;

    EnumTest(String s){
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}