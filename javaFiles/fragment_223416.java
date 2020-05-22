public class DisplayMenuActivity extends AppCompatActivity {

Button nextButton;
TextView word;

public int[] list = {R.string.word_1};
private int listNumber = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_display_menu);



    //Word
    word = (TextView) findViewById(R.id.word);
    word.setText(list[0]);

    //Button
    nextButton = (Button) findViewById(R.id.nextButton);
    nextButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            listNumber++;
            if (listNumber >= list.length) {
                listNumber = 0;
            }
            word.setText(list[listNumber]);
        }
    });
}}