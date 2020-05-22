try {
    // Set the Look and Feel of the application to the operating
    // system's look and feel.
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
}
catch (ClassNotFoundException e) {
}
catch (InstantiationException e) {
}
catch (IllegalAccessException e) {
}
catch (UnsupportedLookAndFeelException e) {
}