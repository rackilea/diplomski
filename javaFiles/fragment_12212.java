JComboBox mComboBox = new JComboBox(new String[]{"One", "Two"}){
    @Override
    public int getSelectedIndex() {
        Object sObject = dataModel.getSelectedItem();
        int i,c;
        Object obj;

        if(sObject==null){
            return 0;
        }
        for ( i=0,c=dataModel.getSize();i<c;i++ ) {
            obj = dataModel.getElementAt(i);

             if ( obj != null && obj.equals(sObject) )
                return i;
        }
        return -1;
    }

    @Override
    protected void selectedItemChanged() {
        fireItemStateChanged(new ItemEvent(this, ItemEvent.ITEM_STATE_CHANGED,
                selectedItemReminder,
                ItemEvent.DESELECTED));
        selectedItemReminder = dataModel.getSelectedItem();

        fireItemStateChanged(new ItemEvent(this, ItemEvent.ITEM_STATE_CHANGED,
                selectedItemReminder,
                ItemEvent.SELECTED));
    }
};