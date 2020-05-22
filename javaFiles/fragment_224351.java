public class NoteFragment extends Fragment {
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;
    private List<String> items;
    //we create this variable for using with different elements
    private View root;
    private Bundle savedState = null;

    public NoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_note,container,false);
        initView();
        setupListViewListener();

        return root;
    }
    //Initializing of view
private void initView(){
    lvItems =(ListView) root.findViewById(R.id.lvItems);
    //creating adapter for viewing list of notes
    List<String> populatedList = readItems();
    items = new ArrayList<>(populatedList);

    itemsAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, populatedList);
    lvItems.setAdapter(itemsAdapter);

    Button b =(Button) root.findViewById(R.id.btnAddItem);
    b.setOnClickListener(mButtonClickListener);
}

//When we use fragment we have to use onClickListener
private View.OnClickListener mButtonClickListener=new View.OnClickListener(){
    public void onClick(View v){
        onAddItem();
    }
};

//method for  adding Items
public  void onAddItem(){
    //initialisation of view for adding notes
    EditText etNewItem =(EditText)root.findViewById(R.id.etNewItem);
    String itemText = etNewItem.getText().toString();
    itemsAdapter.add(itemText);
    items.add(itemText);
    etNewItem.setText(" ");
    writeItems();
}

//When the item is long clicked it removes item
private void setupListViewListener(){
    //attaching a long click listener to the listview
    lvItems.setOnItemLongClickListener(
            new AdapterView.OnItemLongClickListener(){
                @Override
                public boolean onItemLongClick(AdapterView<?> adapter,
                                               View item,int pos,long id){
                    //Remove the item within array at position
                    itemsAdapter.remove(itemsAdapter.getItem(pos));
                    items.remove(pos);
                    //Refresh the adapter
                    itemsAdapter.notifyDataSetChanged();
                    writeItems();
                    //Return true consumes the long click event(marks it handled)
                    return true;
                }
            }
    );
}
//method for writing and reading notes from file
    private List<String> readItems(){
        File filesDir = getActivity().getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");

        try {
            return new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            Log.e("ERROR", e.getMessage());
            return new ArrayList<>();
        }
    }

    private void writeItems() {
        File filesDir = getActivity().getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("ERROR", e.getMessage());
        }
    }

}