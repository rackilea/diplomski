public class MyCustomAdapter extends BaseAdaper {

    private Activity activity;
    private ArrayList<HashMap<String, String>> tracksList;
    private static LayoutInflater inflater = null;

    public MyCustomAdapter(Activity activity, ArrayList<HashMap<String, String>> tracksList) {
        this.activity = activity;
        this.trackList = trackList;  
        this.inflater = (LayoutInflater) activity
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);          
    }

    @Override
    public int getCount() {
        return trackList.size();
    }

    @Override
    public Object getItem(int position) {
        return trackList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        TextView title;
        TextView isSynchronized;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.mycustomlayout, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) convertView
                .findViewById(R.id.track_title);
            holder.isSynchronized = (TextView) convertView
                .findViewById(R.id.is_synchronized);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(tracksList.getTitle());
        holder.isSynchronized.setText(tracksList.isSynchronized());
        //you can do here what ever you want with the textviews like check if its == 0 etc
    }
}