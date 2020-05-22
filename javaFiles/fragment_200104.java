public class SingleItemView extends ListFragment{
SongAdapter songAdapter;
SongsManager songsManager = new SongsManager();
public ArrayList<SongModel> songsList = new ArrayList<>();
public ArrayList<SongModel> recentSongList = Constant.recentSongList;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    View windows = inflater.inflate(R.layout.recent_playlist, container, false);
    Log.i("recent Song List...","..."+recentSongList.size());
    return windows;
}
@Override
public void onViewCreated(View v, Bundle savedInstanceState) {
    super.onViewCreated(v, savedInstanceState);

    final ArrayList<SongModel> songsListData = songsManager.songList;
    Log.i("songsListData...", "" + songsListData.size());
    songAdapter = new SongAdapter(getActivity(),recentSongList);
    setListAdapter(songAdapter);

    final ListView lv = getListView();
    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    });
}}