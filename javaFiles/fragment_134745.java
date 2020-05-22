public class MainActivity extends Activity {
    ObjectClass obj=new ObjectClass();
    LinkedHashMap<String, ObjectClass> mLinkedHashMap = new LinkedHashMap<String, ObjectClass>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        obj.id=1;
        obj.name="hello";

        mLinkedHashMap.put("test", obj);

        Gson gson = new Gson();
        String list = gson.toJson(mLinkedHashMap); 
        Intent intent = new Intent(this, secondActivity.class); 
        intent.putExtra("list", list);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}