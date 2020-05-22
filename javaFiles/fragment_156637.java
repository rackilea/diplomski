public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View toastView = toast.getView();
        Toast toast = Toast.makeText(this,
                                     "This is a Toast message!", 
                                     Toast.LENGTH_LONG);

        toast.setTextColor(Color.WHITE);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toastView.setBackgroundColor(Color.RED);
        toast.show();
    }
}