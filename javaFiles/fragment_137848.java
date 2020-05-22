public class MainActivity extends Activity {

 String names[]={"A","B","C"};
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Onlineliste");

    final LayoutInflater inflater = getLayoutInflater();
    final View convertView2 = (View) inflater.inflate(R.layout.costomdialog, null);
    builder.setView(convertView2);
    ListView lv = (ListView)convertView2.findViewById(R.id.customListView);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.costomdialog, names)
            {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) 
                {
                    View row;

                    if (null == convertView) {
                    row = inflater.inflate(R.layout.customtextrow, null);
                    } else {
                    row = convertView;
                    }

                    TextView tv = (TextView)row.findViewById(R.id.singlerow);
                    tv.setText(names[position]);
                    //tv.setText(getItem(position));

                    return row;
                }

            };
            lv.setAdapter(adapter);
    AlertDialog alert = builder.create();
    alert.show();
     }
   }