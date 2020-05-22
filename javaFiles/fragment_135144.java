public class CsrAdapter extends CursorAdapter {

    public CsrAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_list_with_button,viewGroup,false);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LinearLayout)view.getParent()).setBackgroundColor(0xFFAAFFAA);
            }
        });
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView text1 = view.findViewById(R.id.text1);
        text1.setText(cursor.getString(cursor.getColumnIndex(DBHelper.COL_MYTABLE_NAME)));
    }
}