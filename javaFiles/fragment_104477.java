public class EnumAwareConvertUtilsBean extends ConvertUtilsBean2 {

    private static final EnumConverter ENUM_CONVERTER = new EnumConverter();

    @Override
    public Converter lookup(Class pClazz) {
        final Converter converter = super.lookup(pClazz);

        if (converter == null && pClazz.isEnum()) {
            return ENUM_CONVERTER;
        } else {
            return converter;
        }
    }

}

public class EnumConverter extends AbstractConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnumConverter.class);

    @Override
    protected String convertToString(final Object pValue) throws Throwable {
        return ((Enum) pValue).name();
    }

    @Override
    protected Object convertToType(final Class pType, final Object pValue)
        throws Throwable
    {
        // NOTE: Convert to String is handled elsewhere

        final Class<? extends Enum> type = pType;
        try {
            return Enum.valueOf(type, pValue.toString());
        } catch (final IllegalArgumentException e) {
            LOGGER.warn("No enum value \""
                + pValue
                + "\" for "
                + type.getName());
        }

        return null;
    }

    @Override
    protected Class getDefaultType() {
        return null;
    }

}