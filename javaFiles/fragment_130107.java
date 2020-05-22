public class MyConverter implements Converter<String, GregorianCalendar> {
    @Override
    public GregorianCalendar convertToModel(String value, Class<? extends GregorianCalendar> targetType, Locale locale) throws ConversionException {
        throw new ConversionException("Converting from Presentation to Model is not supported.");
    }

    @Override
    public String convertToPresentation(GregorianCalendar value, Class<? extends String> targetType, Locale locale) throws ConversionException {
        // TODO do the conversion here
        return null;
    }

    @Override
    public Class<GregorianCalendar> getModelType() {
        return GregorianCalendar.class;
    }

    @Override
    public Class<String> getPresentationType() {
        return String.class;
    }
}