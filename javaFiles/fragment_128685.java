public class FoodActivity extends Activity {
    public static  final String EXTRA_MESSAGE2="message";
    Food food1;
    static ArrayList<Food> foodArray = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodArray.add(new Food("Dosa","A South Indian Dish",R.drawable.dosa)) ;
        foodArray.add(new Food("Paneer","A Famous And Delicious Dish made from Paneer",R.drawable.paneer)) ;

        Intent intent=getIntent();
        int Foodno=intent.getExtras().getInt(EXTRA_MESSAGE2);
        food1=foodArray.get(Foodno);
        ImageView image=(ImageView)findViewById(R.id.imageView3);
        image.setImageResource(food1.getFoodImageId());

    }
    public final void onclickfoodimage(View v)
    {
        TextView textview4 =(TextView)findViewById(R.id.textView4);
        textview4.setText(food1.getFoodName());

        TextView textView5 = (TextView)findViewById(R.id.textView5);
        textView5.setText(food1.getFoodDescription());
    }
}