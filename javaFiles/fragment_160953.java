public class WrapperObject {
    @SerializedName("values")
    List<ValueObject> values;

    public List<ValueObject> getValues(){
        return values;
    }
}