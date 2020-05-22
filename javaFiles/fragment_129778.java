public boolean isPanelDisabled() {
    int count = 0;
    for (MyPanel2 panel2 : myPanels) {
        if (panel2.isSelected()) {
            count++;
        }
    }
    return count >= MAX_COUNT;
}