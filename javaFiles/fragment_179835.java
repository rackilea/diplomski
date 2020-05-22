public class MyAdapter extends CursorAdapter {
    private final LayoutInflater mInflater;

    public MyAdapter(Context context, Cursor cursor) {
        super(context, cursor, false);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
         return mInflater.inflate(R.layout.program_date, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        long time = cursor.getLong(cursor.getColumnIndex("DATE_DATE")) * 1000L;

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);

        String format = "M/dd h:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateString = sdf.format(cal.getTime());

        ((TextView) view.findViewById(R.id.text1)).setText(dateString);
    }
}