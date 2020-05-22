@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_overview, null);

    mlistOptions = getResources().getStringArray(R.array.list_options);
    mDrawerLayout = (DrawerLayout) root.findViewById(R.id.drawer_layout);
    mDrawerList = (ListView) root.findViewById(R.id.left_drawer);

    // Set the adapter for the list view
    mDrawerList.setAdapter(new ArrayAdapter<String>(getActivity(),
            R.layout.simple_list_item_1, mlistOptions));

    mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

    return root;
}