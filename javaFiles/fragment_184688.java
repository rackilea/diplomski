int score=0;

public class MainActivity extends AppCompatActivity {
private int score;//this lets me use it else where within the public class
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

TextView tv = (TextView)findViewByID(R.id.tvID);
Button myButton = (Button)findViewByID(R.id.buttonID);
myButton.setOnClickListener(new View.OnClickListener{

    score++;
    tv.setText(score.toString());
});

}