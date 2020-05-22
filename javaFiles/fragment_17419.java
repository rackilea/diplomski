import java8.util.stream.StreamSupport;

StreamSupport.stream(trailers).forEach(trailer -> {
    View reviewView = LayoutInflater.from(mContext).inflate(R.layout.trailer_list_item, null);
    ((TextView) reviewView.findViewById(R.id.movies_trailers_list)).setText(trailer.getName());
    LinearLayout linearLayout = (LinearLayout) mView.findViewById(R.id.movie_trailers);
    linearLayout.addView(reviewView);
});