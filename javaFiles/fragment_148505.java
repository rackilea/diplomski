/**
 * Tool for doing currency formatting
 */
@DefaultKey(value = "currency")
public final class CurrencyTool extends FormatConfig {

    /**
     * Constructor
     */
    public CurrencyTool() {
    }

    /**
     * @param money The {@link Money} object to format
     * @return
     */
    public String format(Money money) {
        // Get the currency as an integer
        final int value = money.getAmountMinorInt();

        // Determine the units and cents
        final int cents = value % 100;
        String units = "" + (value / 100);

        // Final formatted values
        String formattedCents = "";
        String formattedUnits = "";

        // Format the cents to a 2 decimal number
        formattedCents = cents < 10 ? "0" + cents : "" + cents;

        // Format the units to parts of 3 separated with a dot
        if (units.length() > 3) {
            // units is above 999, formatting required

            //Determine the length of the part that doesn't needs to be segmented
            //example: 12 of 12345234 (12.345.234)
            final int nonSegment = units.length() % 3;
            formattedUnits = units.substring(0, nonSegment);

            //place a dot for each segment
            //example: nonSegment (dot) 345 (dot) 234
            units = units.substring(nonSegment, units.length());
            for (String segment : units.split("(?<=\\G...)")) {
                formattedUnits = formattedUnits + "." + segment;
            }
        } else {
            // units is below 1000, no formatting required
            formattedUnits = units;
        }

        return formattedUnits + "," + formattedCents;
    }
}