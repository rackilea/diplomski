public class PlacesAdapter extends ArrayAdapter<Places> {
    public PlacesAdapter(Context context, List<Places> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, View listItemView, @NonNull ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        Places places = getItem(position);

        String name = places.getName();
        ((TextView) listItemView).setText(name);

        return listItemView;
    }
}