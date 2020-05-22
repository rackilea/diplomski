public enum ConstantsEnum{

    SIZE(20)/*...*/;


    private int value;

    ConstantsEnum(int value){
        this.value = value;
    }

    public int getByName(String name){
        return ConstantsEnum.valueOf(name).getValue();
    }

    public int getValue(){
        return value;
    }
}