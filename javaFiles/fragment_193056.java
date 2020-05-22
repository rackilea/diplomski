NumberFormat currency = NumberFormat.getCurrencyInstance(aLocale);
NumberFormat percent = NumberFormat.getPercentInstance(aLocale);
NumberFormat number = NumberFormat.getNumberInstance(aLocale);

int style = DateFormat.MEDIUM;
DateFormat df = DateFormat.getInstance(style,aLocale);