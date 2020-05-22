public class MainActivity extends Activity {

    ChipCount chips; // Don't initialize here, on second thought

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chips = new ChipCount(this); // Initialize here; and pass it `this`, which is an Activity, and also a Context

        TextView number_of_chips = (TextView) findViewById(R.id.number_of_chips);
        int chip = chips.getChips();
        //number_of_chips.setText("500");
    }

}