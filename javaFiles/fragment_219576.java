public class LocalTemperature {

    private final Locale locale;
    private final String temperatureFormat;
    private final float conversionFactor;
    private final float conversionOffset;

    public LocalTemperature(ResourceBundle bundle) {
        locale = bundle.getLocale();
        temperatureFormat = bundle.getString("temperature.decimal.format");
        conversionFactor = Float.parseFloat(bundle.getString("temperature.conversion.factor"));
        conversionOffset = Float.parseFloat(bundle.getString("temperature.conversion.offset"));
    }

    public String format(double kelvin) {
        double localTemperature = conversionOffset + conversionFactor * kelvin;

        DecimalFormat format = new DecimalFormat(temperatureFormat, DecimalFormatSymbols.getInstance(locale));

        return format.format(localTemperature); 
    }
}