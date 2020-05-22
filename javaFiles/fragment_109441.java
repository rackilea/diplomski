@Override
public View onCreateView(@NonNull LayoutInflater inflater,
                         ViewGroup container, Bundle savedInstanceState) {

    View root = inflater.inflate(R.layout.fragment_holiday, container, false);
    RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);
    final HolidayListAdapter adapter = new HolidayListAdapter(getActivity());
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    holidayViewModel =
            ViewModelProviders.of(this).get(HolidayViewModel.class);

    holidayViewModel.getAllHolidays().observe(this, new Observer<List<Holiday>>() {
        @Override
        public void onChanged(@Nullable final List<Holiday> holidays) {
            // Update the cached copy of the words in the adapter.
            adapter.setHolidays(holidays);
        }
    });