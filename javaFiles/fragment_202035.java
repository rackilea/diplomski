public Converter<String, GeneralConfig> getStringToGeneralConfigConverter() {
    return new org.springframework.core.convert.converter.Converter<java.lang.String, GeneralConfig>() {
        public GeneralConfig convert(String id) {
            return getObject().convert(getObject().convert(id, Long.class), GeneralConfig.class);
        }
    };
}