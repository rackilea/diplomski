Integer s = null;

try { 
  s = Integer.valueOf(startField.getText());
}
catch (NumberFormatException e) {
  // ...
}

if (s != null) { ... }