public class MainActivity extends Activity implements View.OnClickListener {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

     Button btnClickMe = (Button) findViewById(R.id.button3);
    btnClickMe.setOnClickListener(MainActivity.this);
}

@Override
public void onClick(View v) {

    EditText e1 = (EditText) findViewById(R.id.editText);
    EditText e2 = (EditText) findViewById(R.id.editText2);
    String Message = e1.getText().toString();
    String Key = e2.getText().toString();
    int MessageLength = Message.length();
    int KeyLength = Key.length();

    int[] ArrKeyValues = new int[MessageLength];
    int i;

    for ( i=0; i<KeyLength; i++){
        char KeyChar = Key.charAt(i);
        int KeyCharValue = (int)KeyChar;
        ArrKeyValues[i] = KeyCharValue;
    }
    int[] ArrMessageValues = new int[MessageLength];


    for(i=0; i< MessageLength; i++){
        char MessageChar = Message.charAt(i);
        int MessageCharValue = (int)MessageChar;
        ArrMessageValues[i] = MessageCharValue;
    }
    char[] CryptedMessage = new char[MessageLength];
    int[] FinalArray = new int[MessageLength];
    String txtr = "";
    for (i=0; i<MessageLength; i++){
        while (ArrKeyValues[i]==0){
            ArrKeyValues[i]=ArrKeyValues[i-KeyLength];
        }
        FinalArray[i] = -ArrKeyValues[i]+ArrMessageValues[i]+127;

        CryptedMessage[i]= (char)FinalArray[i];
        txtr+ = CryptedMessage[i];
    }
       TextView t1 = (TextView)findViewById(R.id.textView2);
       t1.setText(txtr);
   }
}