public class MainActivity extends AppCompatActivity {

Toolbar toolbar;
CollapsingToolbarLayout collapsingToolbarLayoutAndroid;
CoordinatorLayout rootLayoutAndroid;
GridView gridView;
Context context;
ArrayList arrayList;

public static String[] gridViewStrings = {
        "Android",
        "Java",
        "GridView",
        "ListView",
        "Adapter",
        "Custom GridView",
        "Material",
        "XML",
        "Code",

};
public static int[] gridViewImages = {
        R.drawable.android_ic,
        R.drawable.android_ic,
        R.drawable.android_ic,
        R.drawable.android_ic,
        R.drawable.android_ic,
        R.drawable.android_ic,
        R.drawable.android_ic,
        R.drawable.android_ic,
        R.drawable.android_ic
};

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    gridView = (GridView) findViewById(R.id.grid);
    gridView.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {          
          if(gridViewStrings[position].equalsIgnoreCase(String.valueOf(1))){
            Intent intent=new Intent(MainActivity.this,SecoundActivity.class);
              intent.putExtra("image",gridViewImages[position]);
              startActivity(intent);
         }
           else if(gridViewStrings[position].equalsIgnoreCase(String.valueOf(2))){
            Intent intent2=new Intent(MainActivity.this,ThirdActvity.class);
              intent2.putExtra("image2",gridViewImages[position]);
              startActivity(intent2);
         }
       //Like this create activites how many images are there in    gridViewImages[]array.you have 9 images so create nine activities..you have to send the url in every activity from one activity to another activity according to your requirement
        }
    });
    gridView.setAdapter(new CustomAndroidGridViewAdapter(this, gridViewStrings, gridViewImages));
    initInstances();
}
private void initInstances() {
    rootLayoutAndroid = (CoordinatorLayout) findViewById(R.id.android_coordinator_layout);
    collapsingToolbarLayoutAndroid = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_android_layout);
    collapsingToolbarLayoutAndroid.setTitle("Material Grid");
}
}