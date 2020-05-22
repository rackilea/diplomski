double freq; // (1)
try {
  // here I get a DU anomaly
  freq = Double.parseDouble(getFrequencyTextField().getText());
} catch (final NumberFormatException e) {
  Log.e(e.getMessage());
  freq = 0; // (2)
}
if (freq < 10E6) doSomething();