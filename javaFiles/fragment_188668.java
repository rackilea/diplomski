change.setOnAction(action ->{
     String text = changeTextField.getText();
     tableView.getItems().stream()
                         .filter(row -> row.getName().equals(text))
                         .findFirst()
                         .ifPresent(row -> row.setStatus("Running"));
});