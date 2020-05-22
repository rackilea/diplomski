@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    if (DEBUG) Log.d(TAG, "onCreateView(LayoutInflater, ViewGroup,  Bundle)");

    View root = inflater.inflate(R.layout.main_menu, container, false);

    Button fetchDataButton = (Button) root.findViewById(R.id.fetchDataButton);
    ...

    return root;
}