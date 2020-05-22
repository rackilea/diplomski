enum Constants{

    ONE("1"),
    TWO("2");

    private final String value;

    private Constants(String value){
        this.value = value;
    }

    public static Constants findByValue(String value){
        for(Constants constants : values()){
            if(constants.value.equals(value)){
                return constants;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}