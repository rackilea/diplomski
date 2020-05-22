public class FenceActivity extends AppCompatActivity {
    List<Fence> fenceList;
    SQLiteDatabase sqLiteDatabase;
    ListView listViewFences;
    FenceAdapter fenceAdapter;
    DataBaseHelper dataBaseHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savedfences);

        listViewFences = findViewById(R.id.fencesListView);
        fenceList = new ArrayList<>();

        showFencesFromDatabase();
    }

    public void showFencesFromDatabase() {

        dataBaseHelper = new DataBaseHelper(this);
        Cursor cursor = dataBaseHelper.getAllData();
        if (cursor.moveToFirst()) {
            do {
                fenceList.add(new Fence(cursor.getInt(0), cursor.getDouble(1), cursor.getDouble(2), cursor.getInt(3)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        fenceAdapter = new FenceAdapter(FenceActivity.this, R.layout.list_layout_fences, fenceList);
        listViewFences.setAdapter(fenceAdapter);

        listViewFences.setEmptyView(findViewById(R.id.emptyElement));
    }

    public void reloadFencesFromDatabase() {
        dataBaseHelper = new DataBaseHelper(this);
        Cursor cursor = dataBaseHelper.getAllData();
        fenceList.clear();
        if (cursor.moveToFirst()) {
            do {
                fenceList.add(new Fence(cursor.getInt(0), cursor.getDouble(1), cursor.getDouble(2), cursor.getInt(3)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        fenceAdapter = new FenceAdapter(FenceActivity.this, R.layout.list_layout_fences, fenceList);
        listViewFences.setAdapter(fenceAdapter);
        listViewFences.setEmptyView(findViewById(R.id.emptyElement));
    }
}