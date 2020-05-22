public class YourCursorAdapter extends CursorAdapter  {

private Context mContext;
private Cursor mCurser;

public YourCursorAdapter(Context context, int layout, Cursor c, String[] from,
        int[] to, ContentResolver co) {
    super(context, c);
    mCurser = c;
    mContext = context;
}

@Override
public View newView(Context context, Cursor cursor, ViewGroup parent) {
    // TODO Auto-generated method stub
    LayoutInflater inflater = LayoutInflater.from(mContext);
    View v = inflater.inflate(R.layout.contact_entry, parent, false);
    bindView(v, mContext, cursor);
    return v;
}

@Override
public void bindView(View view, Context context, Cursor cursor) {

    TextView contactName= (TextView)view.findViewById(R.id.contactName);
    contactName.setText(cursor.getString((mCurser
            .getColumnIndexOrThrow(Contacts.Phones.DISPLAY_NAME))));
    CheckBox contactCheckbox = (TextView)view.findViewById(R.id.contactCheckbox);
    contactCheckbox.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            Checkbox checkBox = (Checkbox) v.findViewById(R.id.contactCheckbox)
            if (checkBox.isChecked())
                    checkBox.setChecked(false);
            else
                    checkBox.setChecked(true);
        }
    });
}