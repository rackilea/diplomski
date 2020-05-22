ListView listView;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
View rootView = inflater.inflate(R.layout.fragment_players,
            container, false);
listView = (ListView)rootView. findViewById(R.id.players_list);
playerDataHelper = new PlayerDataDatabaseAdapter(getActivity());
playerDataHelper.open();
displayPlayersList();