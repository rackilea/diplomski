public class NumberTest {
    public static void main(String[] args) {
        RectangleForm rf = new RectangleFormReal();
        PolarForm pf = new PolarFormReal();
        Number number = new Number(rf, pf,new BigDecimal(10));
        String rectangleForm = number.rectangleForm();
        String polarForm = number.polarForm();
    }
}