public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
private Button  btn;

Spinner spin1;
Spinner spin2;
Spinner spin3;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

// get spinner in variable
spin1 = (Spinner) findViewById(R.id.spinner1);
...
// Your adapter, ItemListener, DropDownViewResource

spin2 = (Spinner) findViewById(R.id.spinner2);
... // Your adapter, ItemListener, DropDownViewResource 

spin3 = (Spinner) findViewById(R.id.spinner3);
... // Your adapter, ItemListener, DropDownViewResource

Button btn= (Button) findViewById(R.id.display);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        displaycheck();
    }
 });
}


public void displaycheck(){
 String sp1 = spin1.getSelectedItem().toString();
 String sp2 = spin2.getSelectedItem().toString();
 String sp3 = spin3.getSelectedItem().toString();

 // Your combinations check
 if (sp1.equals("3")&&sp2.equals("CSE")&&sp3.equals("B")){
 // based on combination - redirect user
  }
 }
}