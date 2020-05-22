monthView.addPropertyChangeListener(new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent e) {
        if ("firstDisplayedDay".equals(e.getPropertyName())) {
            System.out.println("updated");
        }
    }
});