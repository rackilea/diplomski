@Override
public void onCreate(Bundle savedInstanceState) 
{
  super.onCreate(savedInstanceState);
  ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), 
      android.R.layout.simple_list_item_1, presidents);
  setListAdapter(adapter);
}