JSpinner spinner = new JSpinner();
String pattern = "0.000"; // valid format
JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinner, pattern);
DecimalFormat format = editor.getFormat();
Locale locale = new Locale("ru", "RU"); // create your specific locale
DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(locale);
format.setDecimalFormatSymbols(decimalFormatSymbols);
spinner.setEditor(editor);