Integer vc = 3210000;
NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
DecimalFormat formatter = (DecimalFormat) nf;
formatter.applyPattern("#,###,###");
String fString = formatter.format(vc);
return convertNumbersToEnglish(fString);