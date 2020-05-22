String pattern = "Znaleziono {0,plural,one{# plik}" +
                 "few{# pliki}" +
                 "many{# plików}" +
                 "other{# pliku}}";
MessageFormat fmt = new MessageFormat(pattern, ULocale.forLanguageTag("pl-PL"));
StringBuffer result = new StringBuffer();
FieldPosition zero = new FieldPosition(0);
double[] theNumber = { number };
fmt.format(theNumber, result, zero);