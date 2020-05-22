public class MainActivity extends ActionBarActivity {

    ListView listView;
    CustomAdapter adapter;
    ArrayList<Student> studentArrayList;
    EditText ename, eaddress;
    Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        ename = (EditText)findViewById(R.id.eName);
        eaddress = (EditText)findViewById(R.id.eAddress);
        enter = (Button) findViewById(R.id.enter);

        studentArrayList = new ArrayList<Student>();
        adapter = new CustomAdapter(this,studentArrayList);

        listView.setAdapter(adapter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String got_name = ename.getText().toString();
                String got_address = eaddress.getText().toString();

                if (got_name!=null && got_address!=null)
                {

                    Student student = new Student(got_name, got_address);
                    studentArrayList.add(student);
                    ename.setText(" ");
                    eaddress.setText(" ");
                    adapter.notifyDataSetChanged();

                }

            }
        });



    }


       private class CustomAdapter extends BaseAdapter {


        Context context;
        ArrayList<Student> studentArrayList;

        public CustomAdapter(MainActivity activity, ArrayList<Student> studentArrayList) {

            this.context = activity;
            this.studentArrayList = studentArrayList;
        }


        @Override
        public int getCount() {
            return studentArrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View v = view;

            if (v == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService
                        (Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.custom_row, null);

            }

            TextView studentName  = (TextView)v.findViewById(R.id.studentName);
            TextView studentAddress  = (TextView)v.findViewById(R.id.studentAddress);

            studentName.setText(studentArrayList.get(i).getName());
            studentAddress.setText(studentArrayList.get(i).getAddress());

            return v;
        }
    }
}