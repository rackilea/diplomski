public static final String EXTRA_INGREDIENT_TYPE = "ingredient";

protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        String ingredientType = getIntent().getStringExtra(IngredientsActivity.EXTRA_INGREDIENT_TYPE);
 }