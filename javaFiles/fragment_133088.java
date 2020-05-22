public class SListFragment extends ListFragment {
    private Button cButton;
    private HashMap<Integer, String> hmap = new HashMap<Integer, String>();
    private List<String> list = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    View rootView;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,
                list);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        toggleValues(position);
    }

    @Override
    public int getSelectedItemPosition() {
        return super.getSelectedItemPosition();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.activity_text_demo, container, false);
        cButton = (Button) rootView.findViewById(R.id.btn_contribute);
        cButtonOnClickListener();
        return rootView;
    }

    private void cButtonOnClickListener() {

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cButton.setText("ok");
                Intent cIntent = new Intent(getActivity().getApplication(), MainActivity.class);
                cIntent.putExtra("position", hmap);
                Set<Entry<Integer, String>> sets = hmap.entrySet();
                Iterator<Entry<Integer, String>> it = sets.iterator();
                while (it.hasNext()) {
                    Entry<Integer, String> entry = it.next();
                    Log.d("demo", "hmap key: " + entry.getKey() + " --> value: " + entry.getValue());
                }

                // here hmap is empty; I don't understand why?

                // startActivity(cIntent);
            }
        });
    }

    private void toggleValues(int position) {

        if (hmap.containsKey(position)) {
            hmap.remove(position);
        }
        else {
            hmap.put(position, "position");
        }
    }
}