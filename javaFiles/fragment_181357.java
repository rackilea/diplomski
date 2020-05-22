class CompressedPropertyNamingStrategy extends PropertyNamingStrategyBase {

    private static final long serialVersionUID = 1L;

    private final int length;

    public CompressedPropertyNamingStrategy(int length) {
        this.length = length;
    }

    @Override
    public String translate(String name) {
        if (name.length() < length) {
            return name;
        }

        return name.substring(0, length);
    }
}