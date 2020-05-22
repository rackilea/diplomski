public class FirstScreen extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_screen);

        // call the method you created and pass the activity context
        setClickAnimation(this);
    }
}