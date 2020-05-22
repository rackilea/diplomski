protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if ((requestCode == 1001 || requestCode == 1002 || requestCode == 1003) && resultCode == RESULT_OK){
        MealItem meal = new MealItem();
        meal.setKey(data.getStringExtra("key"));
        meal.setText(data.getStringExtra("text"));
        datasource.update(meal);
        refreshDisplay(requestCode);
    }
}