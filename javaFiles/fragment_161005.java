@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.yourLayoutId, container, false);
    Spinner myspinner=(Spinner) v.findViewById(R.id.fragment_photos_spinner);

    return v;
}