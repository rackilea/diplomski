List<JTextField> fieldList;
List<JSlider> sliderList;
//...
JSlider slider = new JSlider(0, 255);
JTextField field = new JTextField(10);
fieldList.add(field);
sliderList.add(slider);

slider.addChangeListener(new javax.swing.event.ChangeListener() {
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        int index = sliderList.indexOf(slider);
        JTextField field = fieldList.get(index);
        field.setText(Integer.toString(slider.getValue()));
    }
});