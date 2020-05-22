petList.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent event) {
        JComboBox cb = (JComboBox)event.getSource();
        String petName = (String) cb.getSelectedItem();
        System.out.println(petName);
    }
});