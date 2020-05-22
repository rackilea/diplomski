comboBox.addValueChangeListener( new ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {

                Person person = (Person) comboBox.getValue();

                //do something with the selected value
                this.fieldGroup.setItemDataSource(person);              
            }
        });