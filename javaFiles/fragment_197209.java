public abstract class ValueType {

    public abstract void valueSpecificAction(); 
}

public class DoubleValueType extends ValueType {

    private Double value;

    public DoubleValueType(Double value) {
            this.value = value;
    }

    public void valueSpecificAction() {
        //do double specific actions
    }
}

public class StringValueType extends ValueType {

    private String value;


    public void valueSpecificAction() {
        //do string specific actions


     }   
}