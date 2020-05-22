@SuppressWarnings("deprecation")
public RecipeAdapter(Cursor c) {
    super(RecipeActivity.this, c);
}

public RecipeAdapter(Cursor c) {
    // no requeries and no observer required if you change the cursor yourself
    super(RecipeActivity.this, c, 0)
}