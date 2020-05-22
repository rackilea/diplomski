class TimetableAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Timetable> records;
            private final LayoutInflater inflater;

    public TimetableAdapter(Context context, List<Timetable> records) {
        this.context = context;
        this.records = new ArrayList<Timetable>(records);
                    infalter  = LayoutInflater.from(context);
    }

    private static class ViewHolder {
        TextView course;
        TextView room;
        TextView building;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Timetable rowItem = getItem(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.courselist_layout, null);
            holder = new ViewHolder();
            holder.course = (TextView) convertView.findViewById(R.id.course);
            holder.room = (TextView) convertView.findViewById(R.id.room);
            holder.building = (TextView) convertView
                    .findViewById(R.id.building);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.course.setText(rowItem.getCourse());
        holder.room.setText(rowItem.getRoom());
        holder.building.setText(rowItem.getBuilding());

        return convertView;

    }

    @Override
    public int getCount() {
        return records.size();
    }

    @Override
    public Object getItem(int position) {
        return records.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
}