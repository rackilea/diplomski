table.getItems().addListener(new ListChangeListener<T>() {

        @Override
        public void onChanged(Change<? extends T> c) {
            if (tableScrollBar == null){
                tableScrollBar = lookupScrollBar(); 
                tableScrollBar.valueProperty().addListener(new ChangeListener<Number>() {

                    @Override
                    public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
                        // do my job
                    }
                });
            }
        }
    });