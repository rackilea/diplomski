public class MainActivity extends AppCompatActivity {
final private static int NUM_OF_GROUP = 5;
List<Drink> drinksList;
ExpandableListView listView;
ExpandableListAdapterDrinks expandableListAdapterDrinks;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button btRest = findViewById(R.id.btReset);
    Button btOk = findViewById(R.id.btOK);
    listView = findViewById(R.id.elvDrinks);

    initDataList();
    expandableListAdapterDrinks =
            new ExpandableListAdapterDrinks(getApplicationContext(), drinksList, btRest, btOk);
    listView.setAdapter(expandableListAdapterDrinks);
    listView.expandGroup(0);

    btRest.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            expandableListAdapterDrinks.resetTotalSum();
            for(int i=0; i<drinksList.size(); i++) listView.collapseGroup(i);
            listView.expandGroup(0);
        }
    });
    btOk.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String msg = "Nothing Selected";
            Button button = (Button)view;
            if(!button.getText().equals("0")) {
                msg = "Upload!\n";
                ArrayList<SelectedDrink> selectedDrinks = expandableListAdapterDrinks.getOrderList();
                for(SelectedDrink selectedDrink: selectedDrinks) {
                    msg += selectedDrink.content + "    " + selectedDrink.qty + "\n";
                }
                msg += "Total: " + button.getText();
            }
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    });
}

private void initDataList(){
    drinksList = new ArrayList<>();
    List<String> content;
    List<Integer> pricelist;
    List<String> bg;
    for(int i=1; i<=NUM_OF_GROUP; i++) {
        content = new ArrayList<>();
        pricelist = new ArrayList<>();
        bg = new ArrayList<>();
        for(int j = 1; j<(NUM_OF_GROUP + new Random().nextInt(5)); j++){
            content.add("Drink " + i + "-" + j);
            pricelist.add(new Random().nextInt(1000));
            bg.add("#008577");
            bg.add("#D81B60");
        }
        Drink drink = new Drink();
        drink.setTitle("Group " + i);
        drink.setContent(content);
        drink.setPricelist(pricelist);
        drink.setBg(bg);
        drinksList.add(drink);
    }
}
}