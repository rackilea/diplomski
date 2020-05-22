public class CalendarSpinnerAdapter extends BaseAdapter {

    private SimpleDateFormat mDateFormat = new SimpleDateFormat("d MMM yyyy");

    private LayoutInflater mInflater;
    private Calendar mCalendar;
    private int mDayCount;
    private int mLastRequestedDay = 0;

    public CalendarSpinnerAdapter(Context context, int dayCount) {
        mInflater = LayoutInflater.from(context);
        mDayCount = dayCount;
        mCalendar = Calendar.getInstance();
    }

    @Override
    public int getCount() {
        return mDayCount;
    }

    @Override
    public Calendar getItem(int position) {
        mCalendar.add(Calendar.DAY_OF_YEAR, position - mLastRequestedDay);
        mLastRequestedDay = position;
        return mCalendar;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }

        Calendar item = getItem(position);
        ((TextView) convertView).setText(mDateFormat.format(item.getTimeInMillis()));

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}