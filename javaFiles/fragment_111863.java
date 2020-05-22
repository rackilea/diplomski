countyList.setButtonCell(new ListCell(){

        @Override
        protected void updateItem(Object item, boolean empty) {
            super.updateItem(item, empty); 
            if(empty || item==null){
                setStyle("-fx-font-size:15");
            } else {
                setStyle("-fx-font-size:15");
                setText(item.toString());
            }
        }

    });