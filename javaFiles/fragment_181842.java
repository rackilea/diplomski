cell.itemProperty().addListener(new ChangeListener<Object>() {
        @Override
        public void changed(ObservableValue<? extends Object> ov, Object t, Object newValue) {

            if (newValue != null && newValue instanceof Color ) {
                //Do something
                cell.setGraphic(My_Graphic_Object);
            } else {
                cell.setGraphic(null);
            }
        }
    });