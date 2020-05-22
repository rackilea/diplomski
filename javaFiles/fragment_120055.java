String str = ultimaalt.getText();
if (str == null) {
   throw new NullPointerException("No text captured.");
}

if (str.isEmpty()) {
   throw new InvalidStateException("No text captured.");
}