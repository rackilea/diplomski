public class Main2Activity extends AppCompatActivity {

    ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<LevelInfo> list = new ArrayList<LevelInfo>();
        LevelInfo level1 = new LevelInfo(dbHandler.hasObject("puzzel 1 completed"), "Level 1", R.drawable.level1);
        list.add(level1);
        ....
        gridview.setAdapter(new ImageAdapter(this, list));
        ....
    }
 ...
}