public class SongFragment extends Fragment {

String artist;
String song;
int name;
int image;
TextView nameText, artistText;
/* all my code .... */
@Nullable
@Override
public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
   View view = inflater.inflate(R.layout.fragment_main, container, false);
   nameText = view.findByViewId(R.id.my_name_id);
   artistText = view.findByViewId(R.id.my_artist_id);

}
public getSongData(String artist, String song, int name, int image){
   this.artist = artist;
   this.song = song;
   this.name = name;
   this.image = image;

   nameText.setText(name);
   artistText.setText(artist);
}

}