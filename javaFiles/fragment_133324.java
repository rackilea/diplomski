@Bean
public CustomConversions getCustomConversions() {
    return new CustomConversions(Arrays.asList(
        new DBObjectToYearMonthConverter()
    ));
}