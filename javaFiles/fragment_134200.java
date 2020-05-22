public class spinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

Spinner year;
TextView dateView;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_spinner);

    dateView = (TextView) findViewById(R.id.date);

    year = (Spinner) findViewById(R.id.anneeSpinner);
    year.setOnItemSelectedListener(this);
}



@Override
public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    dateView.setText(adapterView.getItemAtPosition(i).toString());
}

@Override
public void onNothingSelected(AdapterView<?> adapterView) {

}
}