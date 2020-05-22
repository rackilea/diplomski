//Locale myLocale = Locale.GERMANY;  //... or better, the current Locale

  Locale myLocale = Locale.getDefault(); // better still

  NumberFormat numberFormatB = NumberFormat.getInstance(myLocale);
  numberFormatB.setMaximumFractionDigits(2);
  numberFormatB.setMinimumFractionDigits(2);
  numberFormatB.setMinimumIntegerDigits(1);

  edit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                    new NumberFormatter(numberFormatB)));