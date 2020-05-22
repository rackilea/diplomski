String spanishDatePattern = "{0,number,00} {1} {2,number,####}";
String spanishLongDateMonthNameNovember = "de noviembre de";

Object[] arguments = { new Integer(date.getDate()),
                       spanishLongDateMonthNameNovember,
                       new Integer(date.getYear()) };
String formattedDate = MessageFormat.format(spanishDatePattern,
                arguments);