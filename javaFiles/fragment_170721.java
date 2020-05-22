// the string "my-condition" is the name of the pseudoclass and appears in the 
// external css file (see below):
PseudoClass myConditionPseudoClass = PseduoClass.getPseudoClass("my-condition");

tableViewAbastecidas.setRowFactory(param -> new TableRow<LeituraPista>() {
    @Override
    protected void updateItem(LeituraPista item, boolean empty) {
        super.updateItem();
        pseudoClassStateChanged(myConditionPseudoClass,  (! empty) && myCondition);
    }
});