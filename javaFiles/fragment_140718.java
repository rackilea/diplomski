private static class ByteToStringConverter implements Converter<String, byte[]> {

    @Override
    public byte[] convertToModel(String value,
            Class<? extends byte[]> targetType,
            Locale locale) throws ConversionException {
        try {
            return value.getBytes("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Exceptions.printStackTrace(ex);
        }
        return null;
    }

    @Override
    public String convertToPresentation(byte[] value,
            Class<? extends String> targetType, Locale locale)
            throws ConversionException {
        return new String(value, StandardCharsets.UTF_8);
    }

    @Override
    public Class<byte[]> getModelType() {
        return byte[].class;
    }

    @Override
    public Class<String> getPresentationType() {
        return String.class;
    }
}