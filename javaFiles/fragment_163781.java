public class ToDoListActivity extends ListActivity {
   ...
   TextView empty;
   TextView empty2;
   ...
   @Override
   public void onCreate(Bundle savedInstanceState) {
    ...
    empty = (TextView) findViewById(android.R.id.empty);
    empty.setVisibility(View.INVISIBLE);
    empty2 = (TextView) findViewById(android.R.id.empty2);
    empty2.setVisibility(View.INVISIBLE);
    ...
}