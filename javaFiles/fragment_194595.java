String test = String.format(Locale.US, "%, d", 1000000000);

or

Locale.setDefault(Locale.US);
String test = String.format("%, d", 1000000000);