new TextField<BigDecimal>("capital", 
        new PropertyModel<BigDecimal>(model, "capital")) {
    @Override
    public <C> IConverter<C> getConverter(Class<C> type) {
        if (type == BigDecimal) {
            return (IConverter<C>) new MonetaryBigDecimalConverter();
        } else {
            return super.getConverter(type);
        }
    }
};