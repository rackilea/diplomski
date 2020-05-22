boolean isCustomFocusSet = false;

protected void onFocus(int direction) {
    if (!isCustomFocusSet) {            
        isCustomFocusSet = true;
        int fieldIndex = getLastFocusedCBIndex();
        CustomField field = (CustomField)getField(fieldIndex);
        field.setFocus();
    } else {
        isCustomFocusSet = false;
        super.onFocus(direction);           
    }
}