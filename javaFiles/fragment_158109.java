@DecimalMin(value = "0.0" ,inclusive = false)
private BigDecimal amd1;

public BigDecimal getAmd1() {
    Double d = (Double) get("amd1");
    return BigDecimal.valueOf(d);
}