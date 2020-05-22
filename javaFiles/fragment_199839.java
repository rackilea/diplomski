formContainer = new JPanel(new BorderLayout());
splitPane.setBottomComponent(formContainer);
formContainer.add(new OrganizationForm());

DataSheetTable dataSheetTable = new DataSheetTable(formContainer);
mainContainer.add(dataSheetTable, BorderLayout.CENTER);
dataSheetTable.start();