double d1 = 123456.78;
double d2 = 567890;
// self commenting issue, the code is easier to understand
Locale fmtLocale = Locale.getDefault(Category.FORMAT);
NumberFormat formatter = NumberFormat.getInstance(fmtLocale);
formatter.setMaximumFractionDigits(2);
formatter.setMinimumFractionDigits(2);
System.out.println(formatter.format(d1));
System.out.println(formatter.format(d2));
System.out.println(fmtLocale.toLanguageTag());