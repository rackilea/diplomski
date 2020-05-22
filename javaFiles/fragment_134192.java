import tec.uom.se.ComparableQuantity;
import tec.uom.se.format.SimpleUnitFormat;
import tec.uom.se.quantity.Quantities;
import javax.measure.quantity.Angle;
import static tec.uom.se.unit.Units.DEGREE_ANGLE;
import static tec.uom.se.unit.Units.RADIAN;

public class CustomLabelForDegrees {

    public static void main(String[] args) {
        ComparableQuantity<Angle> x = Quantities.getQuantity(2.009880307999, RADIAN).to(DEGREE_ANGLE);
        System.out.println(x);
        SimpleUnitFormat.getInstance().label(DEGREE_ANGLE, "°");
        System.out.println(x);
        SimpleUnitFormat.getInstance().label(DEGREE_ANGLE, "☯");
        System.out.println(x);
        SimpleUnitFormat.getInstance().label(DEGREE_ANGLE, "degrees");
        System.out.println(x);
    }
}