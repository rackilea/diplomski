private void jListItemsMouseClicked(java.awt.event.MouseEvent evt) { 
    Component comp = evt.getComponent();

    //added the component to the map or increase the counter
    if(MULTI_CLICK_MAP.containsKey(comp)) {
        MULTI_CLICK_MAP.put(comp, 1);
    } else {
        int oldCounter = MULTI_CLICK_MAP.get(comp);

        MULTI_CLICK_MAP.put(comp, oldCounter + 1);
    }

    //check for double click
    if (MULTI_CLICK_MAP.get(comp) == 2) {
        MULTI_CLICK_MAP.remove(comp);

        //here is your logic
        m_ReturnProduct = (ItemsInfo) jListItems.getSelectedValue();
        if (m_ReturnProduct != null) {
            buttonTransition(m_ReturnProduct);
        }
    } 
    else {

        //start the TimerTask that resets the counter. this will reset after 1 second (1000 milliseconds)
        this.timer.schedule(new ClickReseter(comp), 1000);
    }

}