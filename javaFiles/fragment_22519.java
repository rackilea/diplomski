@Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch(item.getItemId()) {
            case MENU_ITEM_ID:
                yourFunction(); //your function for this particular item
                return true;
        }

        return super.onMenuItemSelected(featureId, item);
    }