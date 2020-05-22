public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> arrayList2 = new ArrayList<>();
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.listItems);
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        arrayList.add("four");
        arrayList.add("five");
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_layout,R.id.textView,arrayList);
        list.setAdapter(arrayAdapter);

        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);


        list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int position, long l, boolean b) {

                count = count+1;
                actionMode.setTitle(count + " items selected");
                arrayList2.add(arrayList.get(position));

            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                MenuInflater inflater = actionMode.getMenuInflater();
                inflater.inflate(R.menu.list_menu,menu);

                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {

                switch (menuItem.getItemId())
                {

                    case R.id.delete_id:

                        for(String msg : arrayList2) {
                            arrayAdapter.remove(msg);

                        }
                            Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();
                            count=0;
                            actionMode.finish();
                        return true;


                    default:
                        Toast.makeText(getApplicationContext(),"Nothing selected",Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                adapterView.setSelected(true);
            }
        });
    }


}