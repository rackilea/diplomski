// Create a new RowFactory to handle actions
tblAccounts.setRowFactory(tv -> {

    // Define our new TableRow
    TableRow<Account> row = new TableRow<>();
    row.setOnMouseClicked(event -> {
        System.out.println("Do your stuff here!");
    });
    return row;
});