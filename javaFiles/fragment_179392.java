public int getSelectedIndex() {
    Object sObject = dataModel.getSelectedItem();
    int i,c;
    E obj;

    for ( i=0,c=dataModel.getSize();i<c;i++ ) {
        obj = dataModel.getElementAt(i);
        if ( obj != null && obj.equals(sObject) )
            return i;
    }
    return -1;