public class HighScoresActivity extends ListActivity {

    private Cursor data;
    private ScoresDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high_scores);

        db = new ScoresDatabase(this);
        data = db.getHighScores();

        ListAdapter adapter = new SimpleCursorAdapter(
                this, 
                R.layout.high_scores_entry, data, 
                new String[] { "level", "moves" }, 
                new int[] { R.id.level_entry, 
                R.id.moves_entry });

        setListAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        data.close();
        db.close();
    }
}