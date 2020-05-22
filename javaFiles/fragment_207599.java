public class SpinnerRes extends AppCompatActivity implements OnItemSelectedListener{

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                final String[] spstr = getResources().getStringArray(R.array.spinnervalue);
                final Spinner sp = (Spinner)findViewById(R.id.spinner1);

                final ArrayAdapter<String> ar = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,spstr);
                sp.setAdapter(ar);

               sp.setOnItemSelectedListener(this);

            }

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

             Spinner spinner = (Spinner) parent;
             if(spinner.getId() == R.id.spinner1)
             {
               //do your staff                   
             }
             else if(spinner.getId() == R.id.spinner2)
             {
               //do your staff
             }

          }

    }