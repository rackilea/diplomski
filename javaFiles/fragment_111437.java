Button   mButton;
EditText mEdit;

@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    mButton = (Button)findViewById(R.id.button);
    mEdit   = (EditText)findViewById(R.id.edittext);

    mButton.setOnClickListener(
        new View.OnClickListener()
        {
          public void onClick(View view)
          {
              try
              {
                 int result = Integer.parseInt(mEdit.getText().toString())/100;
                // show it to them
                Log.v("EditText", "result is "+result);

                Toast.makeText(getApplicationContext(),"result is "+result,     
                               Toast.LENGTH_LONG).show();
              }
              catch (final NumberFormatException e) 
              {
                  // tell them they didnt enter a valid number
                 Toast.makeText(getApplicationContext(),"Please Enter a valid number",     
                               Toast.LENGTH_LONG).show();
              }
          }
    });
}