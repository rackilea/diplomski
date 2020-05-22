manCombo.setConverter(new Converter<Object, Long>() {
        @Override
        public Long convertToModel(Object value, Class<? extends Long> targetType, Locale locale) throws ConversionException {
            if (value == null) {
                return null;
            }
            return ((Manifacturer)value).getId();
        }

        @Override
        public Object convertToPresentation(Long value, Class<?> targetType, Locale locale) throws ConversionException {
            if (value == null) {
                return null;
            }
            return beanItemContainer.getItemIds().stream().filter( m -> value.equals(m.getId()))
                .findFirst().orElse(null);
        }
        ...
});