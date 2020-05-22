public class MainActivity extends AppCompatActivity {

ListView activityList;


protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    activityList = (ListView) findViewById(R.id.activityList);

    String fromArray[] = {"uid", "uname", "ustart"};
    int to[] = {R.id.uid, R.id.uname, R.id.ustart};

    JSONParser jp = new JSONParser(this);
    jp.parseJson();
    /*ListAdapter adapter = new SimpleAdapter(this, jp.userList, R.layout.user_item, fromArray, to);
    activityList.setAdapter(adapter);*/

    }


}