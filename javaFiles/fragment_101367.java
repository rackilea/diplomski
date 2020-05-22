Label l = new Label();

final Locale currentLocale = new Locale("en", "US");
ResourceBundle bundle = ResourceBundle.getBundle("Bundle", currentLocale);
Object[] messageArguments = {new Integer(5)};

MessageFormat formatter = new MessageFormat("");
formatter.setLocale(currentLocale);

formatter.applyPattern(bundle.getString("TEST_BUNDLE_TEXT"));
l.setText(formatter.format(messageArguments));