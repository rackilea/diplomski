@Override
public Object getCellEditorValue() {
    Object v = super.getCellEditorValue();
    BigDecimal n = new BigDecimal(v.toString()).setScale(4, BigDecimal.ROUND_HALF_UP);
    return n.toString();
}