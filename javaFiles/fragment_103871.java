public class DBView extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_stats);
        TextView tv = (TextView) findViewById(R.id.tvDBInfo);
        Stats dbInfo = new Stats(this);
        dbInfo.open();
        dbInfo.createEntry("weight", "waist", "chest", "legs", "arms");
        String data = dbInfo.getData();
        dbInfo.close();
        if (!TextUtils.isEmpty(data)) {
            tv.setText(data);
        }
    }
}