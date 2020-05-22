class CompressedPropertyNamingStrategy extends PropertyNamingStrategyBase {

    private static final long serialVersionUID = 1L;

    @Override
    public String translate(String name) {
        return String.valueOf(name.charAt(0));
    }
}