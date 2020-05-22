AdapterView view = (AdapterView) getActivity().findViewById(R.id.castdetailscredits);

if(view != null)
{
    view.setOnItemClickListener(this);
    ((Scrollable)view).setScrollViewCallbacks(activity.getCastDetailsFragment());
    ((Scrollable)view).setTouchInterceptionViewGroup((ViewGroup) activity.getCastDetailsFragment().getView().findViewById(R.id.containerLayout));
    Bundle save = activity.getCastDetailsCreditsBundle();

    if (save != null) {
        moviesList = save.getParcelableArrayList("moviesList");
        movieAdapter = new MovieAdapter(getActivity(), R.layout.row, this.moviesList);
        view.setAdapter(movieAdapter);
    }
}