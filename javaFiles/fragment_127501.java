private void changeLanguage() {
    Locale locale = comboBox_language.getItemAt(comboBox_language.getSelectedIndex());
    resourceBundle = ResourceBundle.getBundle("Bundle", locale);

    for(ComponentInfo c:allComponentInfos) {
        if(c.getComponent() instanceof JLabel) {
            ((JLabel) c.getComponent()).setText(resourceBundle.getString(c.getKey()));
        } else if(c.getComponent() instanceof JButton) {
            ((JButton) c.getComponent()).setText(resourceBundle.getString(c.getKey()));
        }
    }
}