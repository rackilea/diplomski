@Override
public void propertyChange(PropertyChangeEvent arg0) {
    if (arg0.getPropertyName().equals("buttonClicked")) {
        shutdown();
    }
}