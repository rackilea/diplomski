courseList = new JList(list);   
courseList.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent arg0) {
        String selectedValue = (String) mealsCombo.getSelectedItem();
        if(selectedValue.equals("Main")){
            list.addElement("Main");
        }
    }
});