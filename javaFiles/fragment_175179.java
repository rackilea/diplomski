ULocale uLocale = ULocale.forLanguageTag("pl-PL");
ResourceBundle resources = ResourceBundle.getBundle( "path.to.messages",
                               uLocale.toLocale());
PluralRules pluralRules = PluralRules.forLocale(uLocale);

double[] numbers = { 0, 1, 1.5, 2, 2.5, 3, 4, 5, 5.5, 11, 12, 23 };
for (double number : numbers) { 
  String resourceKey = "some.message.plural_form." + pluralRules.select(number);
  String message = "!" + resourceKey + "!";
  try {
    message = resources.getString(resourceKey);
    System.out.println(format(message, uLocale, number));
   } catch (MissingResourceException e) { // Log this } 
}