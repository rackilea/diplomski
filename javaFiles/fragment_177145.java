@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(SavedInstanceState)
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
    setListAdapter(adapter);
}