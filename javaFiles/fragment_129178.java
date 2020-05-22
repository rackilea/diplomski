@Override
public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, null);
    }

    RestaurantObj restObj = getItem(position);

    TextView restName = (TextView)row.findViewById(R.id.title);
    restName.setText(restObj.getName());

    RatingBar rb = (RatingBar) row.findViewById(R.id.ratingbar);
    rb.setRating(3);

    return convertView;
}