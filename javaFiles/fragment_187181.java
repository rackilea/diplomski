@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
rootView = inflater.inflate(R.layout.gird_layout, container, false);

        //Initialize our array adapter
        mMovieData = new ArrayList<>();
        updateView(mMovieData);
        return rootView;
    }


void updateView(ArrayList<>() movieData){
mMovieAdapter = new MovieAdapter(getActivity(), R.layout.grid_movie_item, movieData);

        //Get a reference to the gridView and attach the adapter to it
        GridView mGridView = (GridView) rootView.findViewById(R.id.gridView);
        mGridView.setAdapter(mMovieAdapter);
}