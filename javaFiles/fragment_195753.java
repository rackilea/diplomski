…
JSlider slider = new JSlider();
panel.add(slider);
int result = JOptionPane.showConfirmDialog(null, panel, "Test",
    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
if (result == JOptionPane.OK_OPTION) {
    System.out.println(combo.getSelectedItem()
        + " " + field1.getText()
        + " " + field2.getText()
        + " " + slider.getValue());
} else {
…