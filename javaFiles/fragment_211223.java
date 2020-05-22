@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    final View v = inflater.inflate(R.layout.tab3, container, false);

    final EditText notes = (EditText) v.findViewById(R.id.editText);
    listView=(ListView)v.findViewById(R.id.list);

    int cross = R.drawable.cross;
    notesofrules = new ArrayList<String>(); //initial data list

    adapter = new CustomListAdapter(this.getActivity(), notesofrules, cross);

    listView=(ListView) v.findViewById(R.id.list);
    listView.setAdapter(adapter); //set the adapter once, only manipulate the data within

    Button button = (Button)v.findViewById(R.id.button3);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v)
        {
            String newNote = notes.getText().toString();
            adapter.addNote(newNote); //add new note to the adapter list
            adapter.notifyDataSetChanged(); //very important to notify adapter and refresh the listview
            notes.setText("");
        }
    });
        return v;
    }
}