@Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            yourButton.enabled=true;
        }
        else if (e.getStateChange() == ItemEvent.DESELECTED) {
            yourButton.enabled=false;
        }
    }