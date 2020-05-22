final PropertyChangeListener pcl = new PropertyChangeListener() {
    public void propertyChange(PropertyChangeEvent e) {
        String prop = e.getPropertyName();

        if (dialog.isVisible() && (e.getSource() == optionPane) && (JOptionPane.VALUE_PROPERTY.equals(prop))){
            java.lang.System.out.println("Code Reached");
            optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);

            optionPane.removePropertyChangeListener(pcl);
        }
    }
}
optionPane.addPropertyChangeListener(pcl);