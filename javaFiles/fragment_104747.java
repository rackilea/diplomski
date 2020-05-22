@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
 View rootView = inflater.inflate(R.layout.activity_filter, container, false);
    setHasOptionsMenu(true);
    getActivity().invalidateOptionsMenu();
    skbrDays = rootView.findViewById(R.id.seekBar);
    daysLostRow = rootView.findViewById(R.id.daysLostRow);
    genderRow = rootView.findViewById(R.id.genderRow);
    locationRow = rootView.findViewById(R.id.locationRow);
    rgupGender = rootView.findViewById(R.id.rgupGender);
    rgupType = rootView.findViewById(R.id.rgupType);
    btnBreed = rootView.findViewById(R.id.btnBreed);
    recyclerView = rootView.findViewById(R.id.recyclerView);

    daysLostRow.setVisibility(View.VISIBLE);

    return rootView;
}