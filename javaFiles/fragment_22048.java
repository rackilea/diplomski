import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ClampedDoublePropertyTest {

    private DoubleProperty numProperty = new SimpleDoubleProperty(0) {

        @Override
        public void set(double value) {

            System.out.println("set("+value+")");
            if (value < 0) {
                value = 0 ;
            }
            if (value > 1) {
                value = 1 ;
            }
            super.set(value);
        }

        @Override
        public void setValue(Number value) {
            System.out.println("setValue("+value+")");
            if (value == null) {
                // depending on requirements, throw exception, set to default value, etc.
            } else {
                if (value.doubleValue() < 0) {
                    value = new Double(0);
                }
                if (value.doubleValue() > 1) {
                    value = new Double(1);
                }
                super.setValue(value);
            }
        }

    };

    public DoubleProperty numProperty() {
        return numProperty;
    }

    public final double getNum() {
        return numProperty().get();
    }

    public final void setNum(double num) {
        numProperty().set(num);
    }

    public static void main(String[] args) {
        ClampedDoublePropertyTest test = new ClampedDoublePropertyTest();
        test.numProperty().addListener((obs, oldValue, newValue) -> System.out.println(oldValue +" -> "+newValue));

        DoubleProperty value = new SimpleDoubleProperty();
        test.numProperty().bind(value);
        value.set(0.5);
        value.set(2);
        value.set(-5);
    }
}