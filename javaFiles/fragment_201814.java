class ConverterUser<TConverter extends IntToStringConverter> {
    public ConverterUser() { ... }

    private TConverter _converter;

    public String convert(Integer from)
    {
        return _converter.convert(from);
    }
}