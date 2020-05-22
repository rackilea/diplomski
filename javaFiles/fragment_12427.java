public class FoodArrayAdapter extends ArrayAdapter<Food> {

private List<Food> mItems;
private Context mContext;
private int mResource;

public FoodArrayAdapter(Context ctx, int resource, List<Food> items) {
    super(activity, resource);
    mItems = items;
    mContext = ctx;
    mResource = resource;
}

@Override
public View getDropDownView(int position, View convertView, ViewGroup parent) {
    //You could use a view holder pattern here, won't really matter for a simple text spinner.
    Food item = mItems.get(position);
    LayoutInflater inflater = (LayoutInflater) mContext
    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View v = inflater.inflate(mResource, parent);
    TextView textView = (TextView) v.findViewById(android.R.id.text1);

    if (item != null) {
        textView.setText(food.getName());
    }

    return v;
}

@Override
public Food getItem(int position) {
    return items.get(position);
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    return getDropDownView(int position, View convertView, ViewGroup parent);
    //or make another view for when the spinner is expanded
}

@Override
public int getCount() {
    return mItems.getSize();
}
}