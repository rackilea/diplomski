public enum DataType {

    @SerializedName("user")
    USER(MeUser.class),
    @SerializedName("product")
    Product(Product.class),
    //other types in the same way, the important think is that 
    //the SerializedName value should be the same as dataType value from json 
    ;


    Type type;

    DataType(Type type) {
        this.type = type;
    }

    public Type getType(){
        return type;
    }
}