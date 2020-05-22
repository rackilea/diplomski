public class MainActivity extends AppCompatActivity{


private EditText editText;
private ListView listView;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    counter = 0;
    Firebase.setAndroidContext(this);
    final Firebase firebase = new Firebase("https://samp-is.firebaseio.com/");


    editText = (EditText) findViewById(R.id.editText);
    listView = (ListView) findViewById(R.id.listView);

    listView.setAdapter(new MessageAdapter(this, Message.class, R.layout.fragment_message, firebase.child("chat")));

    Button button = (Button) findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            counter++;

            Message message = new Message();

            message.setMessage(editText.getText().toString());
            editText.setText("");
            message.setAuthor("Name");
            message.setCounter(counter);
            firebase.child("chat").push().setValue(message);


        }
        });
    }
}