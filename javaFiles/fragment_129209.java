static Double getAbsValue(Object[] values) {
    if (values == null || values.length == 0) {
        return null;
    }
    Double value = (Double) values[0];
    return value > 0 ? value
         : value == 0 ? null
         : -value;
}