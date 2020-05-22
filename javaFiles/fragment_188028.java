public void addConverters(ConversionService service) {
    if (service instanceof ConverterRegistry) {
        ConverterRegistry registry = (ConverterRegistry) service;
        registry.addConverter(new DateToStringConverter());
        registry.addConverter(new DateToLongConverter());
        registry.addConverter(new StringToDateConverter());
        registry.addConverter(new NumberToDateConverter());
        registry.addConverter(new EnumToStringConverter());
        registry.addConverterFactory(new StringToEnumConverterFactory());
    } else {
        throw new IllegalArgumentException("conversionservice is no ConverterRegistry:" + service);
    }
}


public static class DateToLongConverter implements Converter<Date, Long> {

    @Override
    public Long convert(Date source) {
        return source.getTime();
    }
}

public static class NumberToDateConverter implements Converter<Number, Date> {

    @Override
    public Date convert(Number source) {
        return new Date(source.longValue());
    }
}