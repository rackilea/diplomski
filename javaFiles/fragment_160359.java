ComboBox combobox = new ComboBox();
combobox.setEditable(true);
combobox.getEditor().textProperty().addListener(new ChangeListener<String>() {

    @Override
    public void changed(ObservableValue<? extends String> observable, 
                                    String oldValue, String newValue) {
        System.out.println("Text changed");
    }
});