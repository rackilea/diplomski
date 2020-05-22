public static class PlaceholderFragment extends Fragment {

public PlaceholderFragment() {
}

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

    return rootView;
}
private void displayPlayersList() {
Cursor cursor = playerDataHelper.getAllPlayers();

String [] columns = playerDataHelper.columnsToBind();

int [] to = new int[] {
        R.id.player_name,
};

SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(getActivity(), R.layout.fragment_player_details, cursor, columns, to, 0);
listView.setAdapter(dataAdapter);

listView.setOnItemClickListener(new OnItemClickListener(){

    @Override
    public void onItemClick(AdapterView<?> listView, View view, int position, long id)       {
        Cursor cursor = (Cursor) listView.getItemAtPosition(position);

        int player_id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));

        Intent intent = new Intent(getActivity(), EditPlayerActivity.class);
        intent.putExtra("PlayerId", player_id);
        startActivity(intent);      
    }
 });
} 
}