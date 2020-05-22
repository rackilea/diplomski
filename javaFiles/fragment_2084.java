enum Code{

    CODE_A("STRING_A"),
    CODE_B("STRING_B"),
    EMPTY("");

    // Assigning a value to each enum
    private final String code;
    Code(String code){
        this.code = code;
    }

    // Overriding toString() method to return "" instead of "EMPTY"
    @Override
    public String toString(){
        return this.code;
    }

}