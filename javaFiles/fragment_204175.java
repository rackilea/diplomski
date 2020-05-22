@FacesConverter("bigDecimalPlainDisplay")
public class BigDecimalDisplayConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        throw new BigDecimal(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        BigDecimal  bd = (BigDecimal)value;
        return bd.setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
    }
}