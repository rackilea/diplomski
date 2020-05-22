public class SectionListView extends ListActivity {

    private CustomAdapter mAdapter;
    List<String> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new CustomAdapter(this);
        fillList();
        fillAdapter(mAdapter);

        setListAdapter(mAdapter);
    }

    private void fillList(){
        for (int i = 0; i < 10; i++) {
            //this will alternate between "normal" and "advance"
            list.add(i % 2 == 0 ? "normal" : "advance");

            list.add("Text");
            list.add("Text.");
            list.add("Text..");
        }
    }

    private void fillAdapter(CustomAdapter adapter) {
        for (int i = 0; i < list.size(); i++) {
            int row = i % 3;

            if (row == 0) {
                adapter.addSectionHeaderItem(list.get(i) + (i + 1));
                continue;
            }

            adapter.addItem(list.get(i) + (row + 1));
        }
    }
}