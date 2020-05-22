public class SinglePageActivity extends Activity {
    private int pageId;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        pageId = getIntent().getIntExtra("page_id", 1);

        // You can now decide what to display depending on pageId
        switch(pageId) {
        case 1:
            // Code for page 1
            setContentView(R.layout.page_1);
            break;
        case 2:
            // Code for page 2
            setContentView(R.layout.page_2);
            break;
        ...
        }
    }

    public void Next(View v) {
        Intent next = new Intent(this, SinglePageActivity.class);
        next.putExtra("page_id", pageId + 1);
        startActivity(next);
    }

}