public class MapDataFileCursorAdapter extends CursorAdapter {

private LayoutInflater sInflater;
private int fNameColumn;
private int fSnippetColumn;
private int fImageUrlColumn;

public MapDataFileCursorAdapter(Context context, Cursor c, int flags) {
    super(context, c, flags);

    fNameColumn = c.getColumnIndex(MapDataFileDBAdapter.KEY_NAME);
    fSnippetColumn = c.getColumnIndex(MapDataFileDBAdapter.KEY_SNIPPET);
    fImageUrlColumn = c.getColumnIndex(MapDataFileDBAdapter.KEY_IMAGEURL);

    sInflater = LayoutInflater.from(context);
}

@Override
public void bindView(View view, Context context, Cursor cursor) {
    TextView name = (TextView) view.findViewById(R.id.poiDocInfoNameRow);
    name.setText(cursor.getString(fNameColumn));

    TextView info = (TextView) view.findViewById(R.id.poiDocInfoSnippetRow);
    info.setText(cursor.getString(fSnippetColumn));

    ImageView image = (ImageView) view.findViewById(R.id.poiDocInfoLogo);
    String imageUrl = cursor.getString(fImageUrlColumn);

    if (URLUtil.isValidUrl(imageUrl)) {
        image.setEnabled(true);
        image.setVisibility(View.VISIBLE);
        MapDataFileListView.getImageLoader().DisplayImage(imageUrl, null, image);           
    } else {
        image.setImageResource(R.drawable.ic_globe);            
    }

}

@Override
public View newView(Context context, Cursor cursor, ViewGroup parent) {
    return sInflater.inflate(R.layout.mapdatafile_row, null);
}