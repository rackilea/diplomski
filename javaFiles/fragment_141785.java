class MyParser {
    private static final NumberFormat TARGET_FORMAT = 
        new DecimalFormat(Locale.US); // just as an example
    private static final NumberFormat[] ALLOWED = {
        TARGET_FORMAT,
        new DecimalFormat("#,###.") // just as an example
    };

    public Optional<Double> parse(String toParse) {
        for (NumberFormat f : ALLOWED) {
            try {
                double d = f.parse(toParse).doubleValue();
                return Optional.of(d);
            } catch (ParseException e) {}
        }
        return Optional.empty();
    }

    public boolean isProperlyFormatted(String input) {
        return parse(input).isPresent();
    }

    /** Format a value to a proper format */
    public String format(double d) {
        return TARGET_FORMAT.format("%f", d);
    }

    public Optional<String> reformat(String input) {
        return parse(input).map(format);
    }
}