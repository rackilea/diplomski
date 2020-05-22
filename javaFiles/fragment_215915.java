Map<JSlider, JTextField> fieldMap;
//...
fieldMap = new HashMap<>();
//...
JSlider slider = new JSlider(0, 255);
JTextField field = new JTextField(10);
fieldMap.put(slider, field);

slider.addChangeListener(new javax.swing.event.ChangeListener() {
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        JTextField field = fieldMap.get(slider);
        field.setText(Integer.toString(slider.getValue()));
    }
});