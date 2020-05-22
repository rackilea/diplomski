public class Pass extends AppCompatActivity implements View.OnClickListener 
{

private Button btn1;
private EditText text1;
private SharedPreferences sharefPref;
private SharedPreferences.Editor editor;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_pass);

btn1 = (Button) findViewById(R.id.button);
btn1.setOnClickListener(this);

text1 = (EditText) findViewById(R.id.editText);
text1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
editor = sharedPref.edit();
}


public void onClick (View view){

if(sharedPref.getBoolean("YourKey"),true)
{
editor.putBoolean("YourKey",false);
editor.commit();

if (text1.getText().toString().equals("Pass)){
    AlertDialog ad = new AlertDialog.Builder(this).create();
    ad.setMessage("Super");
    ad.show();
    Intent intent = new Intent(this,Popup.class);
    startActivity(intent);

}else{
    String message = "Leider falsch";
    Toast.makeText(this,message, Toast.LENGTH_LONG).show();
}

}
}

}