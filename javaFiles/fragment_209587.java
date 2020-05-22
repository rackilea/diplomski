public class KeywordsCursorAdapter extends CursorAdapter {

    private Context context;

    public KeywordsCursorAdapter(Context context, Cursor c) {
        super(context, c);
        this.context = context;
    }

    //I store the autocomplete text view in a layout xml.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.keyword_autocomplete, null);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String keyword = cursor.getString(cursor.getColumnIndex("keyword"));
        TextView tv = (TextView)view.findViewById(R.id.txtAutocomplete);
        tv.setText(keyword);
    }

    //you need to override this to return the string value when
    //selecting an item from the autocomplete suggestions
    //just do cursor.getstring(whatevercolumn);
    @Override
    public CharSequence convertToString(Cursor cursor) {
        //return super.convertToString(cursor);
        String value = "";
        switch (type) {
        case Keywords:
            value = cursor.getString(DatabaseHelper.KEYWORD_COLUMN);
            break;
        case Cities:
            value = cursor.getString(DatabaseHelper.CITY_COLUMN);
            break;
        }
        return value;
    }

    @Override
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        //return super.runQueryOnBackgroundThread(constraint);
        String filter = "";
        if (constraint == null) filter = "";
        else
            filter = constraint.toString();
                //I have 2 DB-s and the one I use depends on user preference
        SharedPreferences prefs  = PreferenceManager.getDefaultSharedPreferences(context);
        //String selectedCountryCode = prefs.getString("selectedCountry", "GB");
        String selectedCountryCode = prefs.getString(context.getString(R.string.settings_selected_country), "GB");
        selectedCountryCode += "";

                //Here i have a static SQLiteOpenHelper instance that returns a cursor.
        Cursor cursor = MyApplication.getDbHelpers().get(selectedCountryCode.toLowerCase()).getKeywordsCursor(filter);
        return cursor;
    }
}