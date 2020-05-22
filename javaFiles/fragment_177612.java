public void toggleNodeCollapseState(int itemId) {
     for (int i = 0; i < items.size(); i++) {
        Item childItem = items.get(i);
        if (childItem.getParentItemId() == itemId) {
            childItem.setCollapsed(!childItem.isCollapsed);
            if (childItem.isCollapsed) {
                hideItemAndDescendants(childItem);
            } else {
                showDescendants(childItem);
            }
        }
     }
}

public void hideItemAndDescendants(Item item) {
    item.hide();
    for (int i = 0; i < items.size(); i++) {
        Item childItem = items.get(i);
        if (childItem.getId() == item.getId()) {
              hideItemAndDescendants(childItem);
        }
    }
}

public void showDescendants(Item item) {
    item.hide();
    for (int i = 0; i < items.size(); i++) {
        Item childItem = items.get(i);
        if (childItem.getId() == item.getId()) {
            childItem.show();
            if (!childItem.isCollapsed()) {
                showDescendants(childItem);
            }
        }
    }
}