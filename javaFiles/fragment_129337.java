table = builder.table(constraints: BorderLayout.CENTER) {
  tableModel(list: data) {
    propertyColumn(header:'Name', propertyName: 'displayName', editable: false)
    closureColumn(header:'Value', read: IDENTITY,
    cellRenderer: cellRenderer, cellEditor: cellEditor,
    write: {row, newVal->});
} }