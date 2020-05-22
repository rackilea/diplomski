StringBinding stringBinding = new StringBinding() {

    private final static Locale LOCALE  = new Locale("en", "UK");
    private final static DecimalFormat DF;

    static {
        String pattern = "###,###.###;-###,###.###";
        DF = (DecimalFormat) NumberFormat.getNumberInstance(LOCALE);
        DF.applyPattern(pattern);
        DF.setMinimumFractionDigits(3);
        DF.setMaximumFractionDigits(10);
    }

    public StringBinding() {
        super.bind(price1Property(), price2Property());
    }

    @Override
    protected String computeValue() {
        return "price1/price2 " + DF.format(price1Property().get()) + "/" + DF.format(price2Property().get());
    }
};
fxLabel.bind(stringBinding);