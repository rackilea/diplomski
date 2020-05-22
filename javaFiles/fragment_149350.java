// Convert
 BigDecimal conversion = convertCurrency(amountInputText);
 // fetch (to) locale
 Locale locale = ((Currency) toOptions.getSelectedItem()).getLocale();
 // ... & apply
 convertText.setText(NumberFormat
                .getCurrencyInstance(locale)
                .format(conversion));