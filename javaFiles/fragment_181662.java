public class ViewItemClicked extends AppCompatActivity {

    ImageView image;
    TextView name, desc;
    Item item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = (Item) getIntent().getSerializableExtra("dataItem"); // use the key
        setContentView(R.layout.activity_view_item_clicked);
        /*now u can use the item data*/
    }
}