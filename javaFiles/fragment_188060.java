// Get the native look and feel class name
String nativeLF = UIManager.getSystemLookAndFeelClassName();

// Install the look and feel
try {
 UIManager.setLookAndFeel(nativeLF);
} catch (InstantiationException e) {
} catch (ClassNotFoundException e) {
} catch (UnsupportedLookAndFeelException e) {
} catch (IllegalAccessException e) {
}