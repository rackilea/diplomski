@Nullable
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    setHasOptionsMenu(true);

    // Added this section
    if (movieDataList == null) {
        movieDataList = new ArrayList<movieData>();
    }

    if (savedInstanceState != null) {
        index = (Integer) savedInstanceState.getSerializable("POS");

        // Not sure why you had 'not empty'
        if (movieDataList.isEmpty()) {
            movieDataList.addAll(Arrays.asList((movieData[]) savedInstanceState.getSerializable("OLDMOVIEDATA"));
        }
    } // End restore instance state


    View rootView = inflater.inflate(R.layout.movie_display_fragment, container, false);

    movieGridView = (GridView) rootView.findViewById(R.id.gv_movie_display);
    movieAdapter adapter = new movieAdapter(getActivity(),movieDataList);
    movieGridView.setAdapter(adapter);
    movieGridView.setSelection(index);

    return rootView;
}