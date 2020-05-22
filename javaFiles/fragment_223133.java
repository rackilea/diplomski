public class SongFragment extends Fragment {
@Nullable
@Override
public View onCreateView( /* .... */){

Song song = getArguments().getSerializable("song");

}

}