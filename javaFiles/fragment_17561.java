EventHandler evChb = new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {  
        if (event.getSource() instanceof CheckBox) {
            CheckBox chb = (CheckBox) event.getSource();
            chb.setSelected(!chb.isSelected());
        }
    }
};