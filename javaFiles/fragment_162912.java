public class MyClass extends LightEntity {

    @JsonIgnore
    @Override
    public Object getUnderlyingValue() {
        return super.getUnderlyingValue();
    }

}