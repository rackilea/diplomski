public static final int REQUEST_CODE_POPULAR = 1;
    public static final int REQUEST_CODE_TOP_RATED = 2;

    ArrayList<Movie> popularMoviesList = new ArrayList<>();
    ArrayList<Movie> topRatedMoviesList = new ArrayList<>();

    private void setData() {
        String popularMoviesUrl = "yourUrl";
        String topRatedMovieUrl = "yourUrl";
        MovieDataSource object = new MovieDataSource(); // use only one object
        OnResponseListener<ArrayList<Movie>> listener = new OnResponseListener<ArrayList<Movie>>() {
            @Override
            public void onSuccess(int tag, ArrayList<Movie> object) {
                if (tag == REQUEST_CODE_POPULAR) {
                    popularMoviesList = object;
                    // TODO: 5/27/2018 use this list further
                } else if (tag == REQUEST_CODE_TOP_RATED) {
                    topRatedMoviesList = object;
                    // TODO: 5/27/2018 use this list further
                }
            }

            @Override
            public void onError(Exception e) {
//            todo handle error
            }
        };
        object.movieArrayList(popularMoviesUrl, REQUEST_CODE_POPULAR, listener);
        object.movieArrayList(topRatedMovieUrl, REQUEST_CODE_TOP_RATED, listener);
    }