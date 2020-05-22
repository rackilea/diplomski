public class Number {
    private RectangleForm rectangleForm;
    private PolarForm polarForm;
    private BigDecimal value;

    public Number(RectangleForm rectangleForm, PolarForm polarForm,BigDecimal value) {
        this.rectangleForm = rectangleForm;
        this.polarForm = polarForm;
        this.value = value;
    }

    public String polarForm() {
        return polarForm.transform(this.value);
    }

    public String rectangleForm() {
        return rectangleForm.transform(this.value);
    }

    //other methods such as add and subtract
}