class FragmentClass extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.place_autocomplete_fragment, container, false);
        return view;
    }
}