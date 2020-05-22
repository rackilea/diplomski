Here I have written a sample piece which i have used for my application. You can get an idea from this.


        public <C>void addColumn(Cell<C> cell, String headerText,
              final GetValue<C> getter, FieldUpdater<DocumentType, C> fieldUpdater) {
            Column<DocumentType, C> column = new Column<DocumentType, C>(cell) {
              @Override
              public C getValue(DocumentType object) {
                return getter.getValue(object);
              }
            };
            column.setFieldUpdater(fieldUpdater);
            column.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
            getTable().addColumn(column, headerText);
            getTable().setColumnWidth(column, 10, Unit.PX);
    }