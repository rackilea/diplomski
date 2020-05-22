// Create a ResourceBundle out of your property files
ResourceBundle labels =
  ResourceBundle.getBundle("LabelsBundle", currentLocale);

// Get localized value
String value = labels.getString(key);