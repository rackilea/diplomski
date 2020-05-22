// Listen for a mouse click and access the selectedItem property
tblAccounts.setOnMouseClicked(event -> {
    // Make sure the user clicked on a populated item
    if (tblAccounts.getSelectionModel().getSelectedItem() != null) {
        System.out.println("You clicked on " + tblAccounts.getSelectionModel().getSelectedItem().getUsername());
    }
});