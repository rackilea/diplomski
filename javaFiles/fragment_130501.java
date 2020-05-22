public class MainActivity extends Activity
 {
   public void onCreate(Bundle savedInstanceState)
   {
     super.onCreate(savedInstanceState);
     Button F=(Button)findViewById(R.id.formula);
     EditText editText = (EditText) findViewById(R.id.edit);

      F.setOnClickListener(new View.onClickListener()
       {
          public void onClick()
          {
            sendMessage(); 
          }
       }

    }

    public void sendMessage() 
      {
      String message = editText.getText().toString();
      Intent intent = new Intent(MainActivity.this, FormulaActivity.class);
      intent.putExtra("EXTRA_MESSAGE", message);       
      startActivity(intent);
      }
  }