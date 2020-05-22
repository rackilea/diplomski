private void changeStateOfItemsInLayout(ListItem listItem, int p) {
        for (int x = 0; x < listItems.size(); x++) {
            if (x == p) {
                listItem.setShouldBeExpanded(true);
                //Since this is the tapped item, we will skip
                //the rest of loop for this item and set it expanded
                continue;
            }
            listItems.get(x).setShouldBeExpanded(false);
        }
    }