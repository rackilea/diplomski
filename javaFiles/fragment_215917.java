csld[ix].addChangeListener(new javax.swing.event.ChangeListener() {
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        for (int index = 0; index < csld.length; index++) {
            if (csld[index] == slider) {
                txt[index].setText(Integer.toString(slider.getValue()));
                break;
            }
        }

    }
});