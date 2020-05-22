public void itemStateChanged(ItemEvent evt) {

    switch (evt.getStateChanged()) {
        case ItemEvent.DESELECTED:
            // Do what ever you want when the item is deselected
            break;
        case ItemEvent.SELECTED:
            // Do what ever you want when the item is selected
            break;
    }
}