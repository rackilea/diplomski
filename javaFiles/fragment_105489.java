public class MyFragment extends Fragment implements IProcessFilter {
    ...
    ...
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_fragment_layout, container, false);
        no_of_filter = (TextView) view.findViewById(R.id.no_of_filter_tv);

        MyAdapter custom_adapter = new MyAdapter(context, "string 1", "string 2", this);  
    }

    @Override
    public void onProcessFilter(String string1, String string2) {
        // Process the filter
    }
}