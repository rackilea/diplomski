import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.CurrencyData;
import com.google.gwt.i18n.client.CurrencyList;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.i18n.client.constants.CurrencyCodeMapConstants;

public class CustomNumberFormat extends NumberFormat {

  private static CurrencyCodeMapConstants currencyCodeMapConstants = GWT.create(CurrencyCodeMapConstants.class);
  private static char currencySymbol;
  private static NumberFormat cachedCurrencyFormat;

  /**
   * Get the default currency format
   * @return the default currency format
   */
  public static NumberFormat getCurrencyFormat() {
    if (cachedCurrencyFormat == null) {
      cachedCurrencyFormat = getCurrencyFormat(CurrencyList.get().getDefault().getCurrencyCode());
    }
    return cachedCurrencyFormat;
  }

  /**
   * Get the currency format
   * @param currencyCode the code to use
   * @return the {@link NumberFormat} to use
   */
  public static NumberFormat getCurrencyFormat(final String currencyCode) {
    return new CustomNumberFormat(defaultNumberConstants.currencyPattern(), lookupCurrency(currencyCode), false, true);
  }

  /**
   * Lookup the currency data
   * @param currencyCode the currency code e.g. EUR
   * @return the {@link CurrencyData}
   */
  private static CurrencyData lookupCurrency(final String currencyCode) {
    final CurrencyData currencyData = CurrencyList.get().lookup(currencyCode);

    final Map<String, String> currencyMap = currencyCodeMapConstants.currencyMap();

    final String code = currencyData.getCurrencyCode();
    final String symbol = currencyMap.get(currencyCode);
    final int fractionDigits = currencyData.getDefaultFractionDigits();
    final String portableSymbol = currencyData.getPortableCurrencySymbol();
    return toCurrencyData(code, symbol, fractionDigits, portableSymbol);
  }

  /**
   *
   * @param code the currency code e.g. EUR
   * @param symbol the currency symbol e.g. the euro sign
   * @param fractionDigits the number of fraction digits
   * @param portableSymbol the portable symbol
   * @return the {@link CurrencyData} to use
   */
  public static native CurrencyData toCurrencyData(String code, String symbol, int fractionDigits,
      String portableSymbol) /*-{
                             //CHECKSTYLE:OFF
                             return [ code, symbol, fractionDigits, portableSymbol ];
                             //CHECKSTYLE:ON
                             }-*/;

  private boolean currencyFormat = false;

  /**
   *
   * @param pattern the currency pattern
   * @param cdata the {@link CurrencyData}
   * @param userSuppliedPattern <code>true</code> if the pattern is supplied by the user
   */
  protected CustomNumberFormat(final String pattern, final CurrencyData cdata, final boolean userSuppliedPattern,
      final boolean currencyFormat) {
    super(pattern, cdata, userSuppliedPattern);
    this.currencyFormat = currencyFormat;
  }

  /* (non-Javadoc)
   * @see com.google.gwt.i18n.client.NumberFormat#format(boolean, java.lang.StringBuilder, int)
   */
  @Override
  protected void format(final boolean isNegative, final StringBuilder digits, final int scale) {
    super.format(isNegative, digits, scale);
    if (this.currencyFormat) {
      final char decimalSeparator = defaultNumberConstants.monetarySeparator().charAt(0);
      if (digits.toString().endsWith(decimalSeparator + "00")) {
        digits.delete(digits.length() - 3, digits.length());
      }
      if (isNegative) {
        digits.delete(digits.length() - 1, digits.length()); // Delete leading "-"
        digits.insert(0, "- "); // Insert "- " at the front
      }
    }
  }

  /**
   * Parse a String. The String does not start with the expected prefix so we add it first
   * @param text the text to parse
   * @param inOutPos an offset telling us
   * @return the parsed value
   * @throws NumberFormatException if the text cannot be parsed
   */
  @Override
  public double parse(final String text, final int[] inOutPos) throws NumberFormatException {
    //add the positive prefix (euro-sign plus space)
    final String temp = getPositivePrefix() + text;
    //parse the adjusted string
    final double val = super.parse(temp, inOutPos);
    //now here is the tricky bit... during parsing the inOutPos offset was updated based on the modified String
    //but a check is maded to see if the resulting offset is equal to the length of the String we have been passed
    //so we need to update inOutPos by removing the length of the positive prefix
    inOutPos[0] -= getPositivePrefix().length();
    return val;
  }
}