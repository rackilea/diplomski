public class MainActivity extends AppCompatActivity {

    itemDB ItemDBHlpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemDBHlpr = new itemDB(this);
        Item myItem = new Item("tjastjtjjta",0.0,1372.0450878788292,1372.0450878788292,"tuarhwrqhh");
        ItemDBHlpr.addItem(myItem);
        List<Item> myItemList = ItemDBHlpr.getAllItems();
        for (Item i: myItemList) {
            Log.d("ITEMFROMLIST",
                    "Item Name is " + i.getName() +
                            "\n\tInitial Price = " + String.valueOf(i.getPriceInitial()) +
                            "\n\tCurrent Price = " + String.valueOf(i.getPriceCurrent()) +
                            "\n\tPrice Change = " + String.valueOf(i.getPriceChange()) +
                            "]n]tURL = " + i.getUrl()
            );
        }
    }
}