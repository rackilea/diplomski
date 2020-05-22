public class MyBigDecimal extends BigDecimal {

    public MyBigDecimal(String val) {
        super(val);
    }

    public String print() {
        return divide(new BigDecimal("100")).toPlainString();
    }

}