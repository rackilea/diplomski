try {
  // here I get a DU anomaly
  double freq = Double.parseDouble(getFrequencyTextField().getText());

  if (freq < 10E6) doSomething();
  ...

} catch (final NumberFormatException e) {
  Log.e(e.getMessage());
}