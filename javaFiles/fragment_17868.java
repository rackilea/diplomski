JList list = new JList(model);
list.setCellRenderer(new DefaultListCellRenderer(){
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if(value instanceof Person){
            Person person = (Person)value;
            setText(person.getName() + " " + person.getLastName());
        }
        return this;
    }
});