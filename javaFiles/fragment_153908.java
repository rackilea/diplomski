public class MyActivity extends Activity {

    private DatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initialise your helper here
        myDatabaseHelper = ...
    }

    public void onClickListenerButton(){

        // All your other stuff here...

        // variable that  I want to pass
        String avgStdLivingText = selectedAvgStdsRb.getText().toString();
        myDatabaseHelper.showResults(avgStdLivingText);
    }

}