public void itemStateChanged(ItemEvent e) {
    Object source = e.getSource();
    if(e.getStateChange()==ItemEvent.SELECTED) {
        if(source.equals(box1) || source.equals(box2) {
            total1 = box1prices[box1.getSelectedIndex()];
            total2 = box2prices[box2.getSelectedIndex()];
            label2.setText("Rental Amount Due: " + total1 + " and " + total2);
        }
    }
}