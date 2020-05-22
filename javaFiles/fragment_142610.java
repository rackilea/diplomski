public class CurrencyActivity extends Activity {
double valA; 
double valB;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.currency);


final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
    final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
    final EditText etResult = (EditText) findViewById(R.id.etResult);
    final MyData items[] = new MyData[3];
    items[0] = new MyData("EUR, Euro",1);
    items[1] = new MyData("GBP, British Pound",5);
    items[2] = new MyData("USD, US Dollar",15);

ArrayAdapter<MyData> adapter = new ArrayAdapter <MyData>(this,  android.R.layout.simple_spinner_item, items);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner1.setAdapter(adapter);
spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        MyData d = items[pos];
        valA=d.getValue();
}

    @Override
    public void onNothingSelected(AdapterView parent){
        //Do nothing

}
});



spinner2.setAdapter(adapter);
spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        MyData d = items[pos];
        valB = d.getValue();
        }
    @Override
    public void onNothingSelected(AdapterView parent){
        //Do nothing
    }
 });

public void divideVals(){

    double result = valA / valB;
    etResult.setText(String.valueOf(result));
}