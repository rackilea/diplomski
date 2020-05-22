public class StoreCursorAdapter extends SimpleCursorAdapter {
private static final String TAG = "VenueCursorAdapter";

DatabaseHelper databaseHelper;
private Context context;
private int layout;

private int selection; //MapsActivity.getStoreSelection();

public StoreCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
    super(context, layout, c, from, to, flags);

    databaseHelper = DatabaseHelper.getInstance(context);
    this.context = context;
    this.layout = layout;
}

@Override
public View newView(Context context, Cursor cursor, ViewGroup parent) {

    final LayoutInflater inflater = LayoutInflater.from(context);
    View v = inflater.inflate(layout, parent, false);

    return v;
}

@Override
public void bindView(View v, Context context, Cursor c) {

    selection = ((MapsActivity) context).getStoreSelection();

    int position = c.getPosition();

    int nameColumn = c.getColumnIndex(DatabaseHelper.KEY_VENUE_NAME);

    String name = c.getString(nameColumn);

    TextView nameText = (TextView) v.findViewById(R.id.nameTextView);
    TextView ratingText = (TextView) v.findViewById(R.id.ratingTextView);

    if(nameText != null && ratingText != null) {
        nameText.setText(name);

    }

}
}