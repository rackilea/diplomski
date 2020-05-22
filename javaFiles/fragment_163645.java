public class Bamanual extends Fragment {
    ListView listView;
    ArrayList<Photo> list_data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bamanual, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView1);
        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Menu Ba Manual");
        getJSON("http://192.168.3.223:84/fppb/andro_login/fppb");
    }

    private void loadIntoListView(String json) throws JSONException {
        List<Photo> items = new ArrayList<Photo>();

        JSONArray jsonArray = new JSONArray(json);
        String[] ba = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            String code=obj.getString("ItemCode");
            String name=obj.getString("PhotoName");
            items.add(new Photo(code, name);
        }
        ArrayAdapter<Photo> mArrayAdapter = new ArrayAdapter<Photo>(getActivity(),android.R.layout.simple_expandable_list_item_1, items);
        listView.setAdapter(mArrayAdapter);
        //Toast.makeText(getActivity(), jsonArray.toString(), Toast.LENGTH_LONG).show();
    }