public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    /* Inflate the layout for this fragment */
    View view = inflater.inflate(R.layout.fragment_where_root, container, false);

    // Use child fragment manager to manage WhereMainFragment
    FragmentTransaction transaction = getChildFragmentManager()
            .beginTransaction();
    transaction.replace(R.id.where_root_frame, MainActivity.whereMainFragment);
    transaction.addToBackStack(null);
    transaction.commit();

    return view;
}