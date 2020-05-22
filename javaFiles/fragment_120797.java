//'myListView' is your ListView, 'myTextField' is your textfield
ObservableList<String> rawData= FXCollections.observableArrayList();
FilteredList<String> filteredList= new FilteredList<>(rawData, data -> true);
myListView.setItems(filteredList);
myTextField.textProperty().addListener(((observable, oldValue, newValue) -> {
        filteredList.setPredicate(data -> {
            if (newValue == null || newValue.isEmpty()){
                return true;
            }
            String lowerCaseSearch=newValue.toLowerCase();
            return String.valueOf(data.contains(lowerCaseSearch);
        });
    }));