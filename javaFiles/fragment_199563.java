private void LoadSelections() {
    // if the selections were previously saved load them
    SharedPreferences settingsActivity = getPreferences(MODE_PRIVATE);
    if (settingsActivity.contains(data.toString())) {
        String savedItems = settingsActivity.getString(data.toString(), "");
        ArrayList<String> savedItemsList = (ArrayList<String>) Arrays.asList(savedItems.split(","));
        int count = this.mList.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            String currentItem = (String) this.mList.getAdapter().getItem(i);
            if (savedItemList.contains(currentItem)) {
                this.mList.setItemChecked(i, true);
            } else {
                this.mList.setItemChecked(i, false);
            }
        }
    }
}