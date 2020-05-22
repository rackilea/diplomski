//...
Widget widget = uiBinder.createAndBindUi(this);
table.setWidth("100%", true);
table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

initTableColumns();

// Push the data into the widget.
table.setRowData(CONTACTS);

// Set table width.
table.setWidth("100%");