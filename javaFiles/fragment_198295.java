public class NumberOpp {
    public static <T extends Number> double power(T base, int pow) {
        if (pow == 1) {
            return base.doubleValue ();
        } else {
            return base.doubleValue () * NumberOpp.power(base, pow - 1);
        }
    }
}