List<Ingredient> ingredientsList= new ArrayList<Ingredient>(); 
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    for(int i=0;i<10;i++)
    {
        ingredientsList.add(new Ingredient("foo"+i));
    }
   ArrayAdapter<Ingredient> adapter = new ArrayAdapter<Ingredient>(this,android.R.layout.simple_list_item_1,ingredientsList);
   ListView lv= (ListView) findViewById(R.id.listView1);
   lv.setAdapter(adapter);
  }
  }