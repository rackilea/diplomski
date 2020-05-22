public class MainActivity extends AppCompatActivity {
boolean[] connect_btn_pressed ;
ImageButton btn_up,btn_connect ;
TextView ble_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect_btn_pressed = {false};

        btn_up = (ImageButton) findViewById(R.id.btn_up);
        btn_connect = (ImageButton) findViewById(R.id.btn_connect);
        ble_status = (TextView) findViewById(R.id.bt_message);

        btn_up.setVisibility(View.INVISIBLE);

        btn_connect.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(connect_btn_pressed[0] == false){
                    ble_status.setText("Connecting...");
                    btn_connect.setImageResource(R.drawable.btn_x1_bt_on);
                    btn_up.setVisibility(View.VISIBLE);
                    connect_btn_pressed[0] = true;
                }
                else {
                    ble_status.setText("Cancelled");
                    btn_connect.setImageResource(R.drawable.btn_x1_bt_off);
                    btn_up.setVisibility(View.INVISIBLE);
                    connect_btn_pressed[0] = false;
            }
        }
    });
}