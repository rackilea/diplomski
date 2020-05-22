public class MainActivity extends AppCompatActivity {

    TextView user_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_text = (TextView) findViewById(R.id.user_text);

    }

    public void moveLeft(View view)
    {
        user_text.setX(user_text.getX() - 10);
    }

    public void moveUp(View view)
    {
        user_text.setY(user_text.getY() - 10);

    }

    public void moveDown(View view)
    {
        user_text.setY(user_text.getY() + 10);

    }

    public void moveRight(View view)
    {
        user_text.setX(user_text.getX() + 10);
    }
}