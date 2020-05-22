public class secondActivity extends Activity {
    LinkedHashMap<String, ObjectClass> mLinkedHashMap = new LinkedHashMap<String, ObjectClass>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     String str=  getIntent().getStringExtra("list");
     Gson gson = new Gson();

     Type entityType = new TypeToken< LinkedHashMap<String, ObjectClass>>(){}.getType();
     mLinkedHashMap = gson.fromJson(str, entityType);
    ObjectClass obj = mLinkedHashMap.get("test");

     Log.i("list", ""+obj.id);
    }
}