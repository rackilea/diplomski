public void onClick(View v){
    MealItem meal = MealItem.getNew();
    Intent i = new Intent(this, MealEditor.class); // Meal Editor is the activity where the user enters the note which is displayed in the text view
    i.putExtra("key", meal.getKey());
    i.putExtra("text", meal.getText());
    if(v.getId() == R.id.breakfast) // use your breakfast button id here
        startActivityForResult(i, 1001); 
    else if(v.getId() == R.id.lunch) // use your lunch button id here
        startActivityForResult(i, 1002);
    else if(v.getId() == R.id.dinner) // use your dinner button id here
        startActivityForResult(i, 1003);
}