public class CustomMongoConfiguration extends AbstractMongoConfiguration {

  @Bean
  @Override
  public CustomConversions customConversions() {

    Converter<Currency, String> currencyToString = source -> source.toString();
    Converter<String, Currency> stringToCurrency = source -> Currency.getInstance(source);

    return new CustomConversions(Arrays.asList(currencyToString, stringToCurrency));
  }
}