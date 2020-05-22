public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_message);
        Button button = (Button) findViewById(R.id.btnSendSMS);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                EditText textPhone = (EditText) findViewById(R.id.phoneNum);
                EditText textSms = (EditText) findViewById(R.id.smsContent);
                final String phoneNumber = textPhone.getText().toString();
                final String message = textSms.getText().toString();
                Map<String, Object> results = new HashMap<String, Object>();
                results.put("phoneNmbr", "" + phoneNumber);
                results.put("message", "" + message);
            }
        });
    }
}