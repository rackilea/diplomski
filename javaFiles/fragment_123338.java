@FXML
public void onEditFieldValueCommit(TableColumn.CellEditEvent<MesssageField, String> t) {
    t.getRowValue().setFieldValue(t.getNewValue());

    System.out.print("\n[DEBUG] Field Name = " + t.getRowValue().getFieldName() + 
            " = " + t.getRowValue().getFieldValue());
}