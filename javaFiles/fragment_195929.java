private void onStateChange(java.awt.event.ItemEvent evt) {
        Object selectedItem = evt.getItem();
        if (selectedItem.equals("X")) {
            jTextField1.requestFocus();
        } else if (selectedItem.equals("Y")) {
            jTextField2.requestFocus();
        } else if (selectedItem.equals("Z")) {
            jTextField3.requestFocus();
        }
    }