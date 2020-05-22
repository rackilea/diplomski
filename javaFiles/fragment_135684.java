private void refreshDisplay(int code) {
    mealsList = datasource.findAll();
    ArrayAdapter<MealItem> adapter =
            new ArrayAdapter<MealItem>(this, R.layout.list_item_layout, mealsList);
    if(code == 1001)
        mLBMon.setAdapter(adapter);
    else if(code == 1002)
        mLLMon.setAdapter(adapter);
    else if(code == 1003)
        mLDMon.setAdapter(adapter);
}