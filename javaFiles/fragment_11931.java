public class YoutubeFragment extends Fragment {

private static final String API_KEY = DateUtils.getDeveloperKey();


private static String VIDEO_ID;


public void setVideoID(String id){
    VIDEO_ID = id;
}


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.youtube_layout, container, false);


    YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();


    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
    transaction.add(R.id.youtube_layout, youTubePlayerFragment).commit();


    youTubePlayerFragment.initialize(API_KEY, new OnInitializedListener() {


        @Override
        public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
            if (!wasRestored) {
                player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                player.loadVideo(VIDEO_ID);
                player.play();
            }
        }

        @Override
        public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
            // YouTube error
            String errorMessage = error.toString();
            Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
            Log.d("errorMessage:", errorMessage);
        }
    });

    return rootView;
}
}