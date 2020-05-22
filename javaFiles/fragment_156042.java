public class AutocompleteViewss extends AppCompatActivity {

AutoCompleteTextView autocompleteViewss;

ArrayList<String> WorkTypes;
ArrayAdapter<String> adapter;

String selecteditems = "";

TextInputEditText  editText_addwork;

TextInputLayout cat_types;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_autocomplete_textview);


    autocompleteViewss = (AutoCompleteTextView) findViewById(R.id.category_auto);

    editText_addwork  = (TextInputEditText) findViewById(R.id.addwork);

    cat_types   = (TextInputLayout) findViewById(R.id.cat_types);


    WorkTypes = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.WorkTypes)));

    Toast.makeText(AutocompleteViewss.this,""+WorkTypes.size(),Toast.LENGTH_LONG).show();

    adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_dropdown_item_1line, WorkTypes);

    autocompleteViewss.setAdapter(adapter);



    autocompleteViewss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            selecteditems = (String) parent.getItemAtPosition(position);

            Log.d("displaythe",""+selecteditems);

            editText_addwork.setEnabled(true);
            cat_types.setError("");


        }
    });


    editText_addwork.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Log.d("seleceditems","***    "+selecteditems);

            if (selecteditems.equals("")){
                cat_types.setError("Please Select Types");

                Toast.makeText(AutocompleteViewss.this,"Please Select Work Types",Toast.LENGTH_LONG).show();
            }else {
                cat_types.setError("");

                Toast.makeText(AutocompleteViewss.this,"Show Dialog here",Toast.LENGTH_LONG).show();
                /* Show dialog here */

           }

        }
    });

}