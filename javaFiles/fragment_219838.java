public class Play extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_play);

    ViewGroup content = (ViewGroup)findViewById(R.id.container);  //<-this id from xml

    Intent intent=getIntent();
    String n = intent.getStringExtra("NUM");
    int times = Integer.parseInt(n);

    TextView [] espaces = new TextView[times];

    for(int i = 0; i < espaces.length; i++){

        espaces[i] = new TextView(this);
        espaces[i].setText(" __ ");
        content.addView(espaces[i]);//<-add to view group and not replace content view of activity

    }

}
}