alcohol.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) { 
        Intent i = new Intent (TypeActivity.this,IngredientsActivity.class);
        i.putExtra(IngredientsActivity.EXTRA_INGREDIENT_TYPE, "alcohol");
        startActivity(i);
    }
});