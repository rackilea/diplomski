public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View btn = findViewById(R.id.clickMe);
        btn.setTag(NotifService.CHANNEL_ID_MAIN);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String channelId = (String) v.getTag();
                Intent intent = new Intent(v.getContext(), NotifService.class);
                intent.putExtra(NotifService.TAG, channelId);
                if (channelId.equals(NotifService.CHANNEL_ID_MAIN)) {
                    v.setTag(NotifService.CHANNEL_ID_SOUND);
                } else {
                    v.setTag(NotifService.CHANNEL_ID_MAIN);
                }
                v.getContext().startService(intent);
            }
        });
    }
}