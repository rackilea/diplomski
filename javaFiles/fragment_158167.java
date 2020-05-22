TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
 tableViewerColumn.setLabelProvider(new ColumnLabelProvider() {

     public String getText(Object object) {
         int index = 1;
         for (String employee : company.getEmployeeNames()) {
             if (employee == object) 
                 return String.valueOf(index);
             index++;
         }
         return "";
     }
});