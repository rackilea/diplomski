public class QuestionDetails extends SherlockFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        // If not already added to the Fragment manager add it. If you don't do this a new Fragment will be added every time this method is called (Such as on orientation change)
        if(savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, new StickyQuestionDetailsFragment()).commit();
    }
}