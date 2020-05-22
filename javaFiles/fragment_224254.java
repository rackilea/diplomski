EditText FirstInput;

@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.your_layout);

    FirstInput   = (EditText)findViewById(R.id.FirstInput);
    try{
    int firstValue = Integer.parseInt(FirstInput.getText().toString());
    }catch(Exception e){
     // Do something to handle the error;
    }
}