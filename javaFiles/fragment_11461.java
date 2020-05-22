@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_main, container, false);
    songView = (ListView) v.findViewById(R.id.song_list);
    return v;
}

@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    songList = new ArrayList<Song>();

    getSongList();

    Collections.sort(songList, new Comparator<Song>(){
        public int compare(Song a, Song b){
            return a.getTitle().compareTo(b.getTitle());
        }
    });

    // Note that I removed 'this' (referring to the Activity) from the adapter's constructor since we are now in a Fragment.
    //and replaced it with getActivity()
    SongAdapter songAdt = new SongAdapter(getActivity(), songList);
    songView.setAdapter(songAdt);