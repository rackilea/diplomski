public void disableBoxes() {
    for (JCheckBox j : ArrayOfJCheckBox) {
        if (j.isEnabled()) {
            j.setEnabled(false);
        }
    }
}