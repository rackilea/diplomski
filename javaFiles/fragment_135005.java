public class NyTimesFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Story>> {

public static final String LOG_TAG = NyTimesFragment.class.getName();
    private static final String NY_TIMES_URL = "nyTimesURL";
    private StoryAdapter mAdapter;
    private TextView mEmptyTextView;
    private View rootView;

    public NyTimesFragment(String url) {
        Bundle b = new Bundle();
        b.putExtra(NY_TIMES_URL, url); // Pass URL here
        setArguments(b);
    }

    public NyTimesFragment() {
        // Required empty public constructor
    }

    @Override
    public android.content.Loader<List<Story>> onCreateLoader(int i, Bundle bundle) {
        // Load url here
        String url = getArguments().getString(NY_TIMES_URL);
        return new StoryLoader(getActivity(), url);
    }