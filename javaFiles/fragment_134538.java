public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.movie_details, container,
                false);
        ListView list = (ListView) rootView.findViewById(R.id.reviewsList);
        adapter = new ReviewsAdapter(inflater);
        list.setAdapter(adapter);
        System.out.println("HERE");
        DownloadReviews task = new DownloadReviews(url);
        task.execute(new Void[0]);
        System.out.println("THERE");
        return rootView;

    }