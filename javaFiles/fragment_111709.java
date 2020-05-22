public class MainMenuActivity extends WearableActivity {

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_menu);
    WearableRecyclerView recyclerView = findViewById(R.id.main_menu_view);
    recyclerView.setHasFixedSize(true);
    recyclerView.setEdgeItemsCenteringEnabled(true);
    recyclerView.setLayoutManager(new WearableLinearLayoutManager(this));

    ArrayList<MenuItem> menuItems = new ArrayList<>();
    menuItems.add(new MenuItem(R.drawable.icon_1, "Item 1"));
    menuItems.add(new MenuItem(R.drawable.icon_2, "Item 2"));
    menuItems.add(new MenuItem(R.drawable.icon_3, "Item 3"));
    menuItems.add(new MenuItem(R.drawable.icon_4, "Item 4"));

    recyclerView.setAdapter(new MainMenuAdapter(this, menuItems, new MainMenuAdapter.AdapterCallback() {
        @Override
        public void onItemClicked(final Integer menuPosition) {
            switch (menuPosition){
                case 0:  action_1(); break;
                case 1:  action_2(); break;
                case 2:  action_3(); break;
                case 3:  action_4(); break;
                default : cancelMenu();
            }
        }
    }));
}