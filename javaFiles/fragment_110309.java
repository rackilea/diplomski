public class ListAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<String> name;
    private static LayoutInflater inflater=null;

    public ListAdapter(Activity a, ArrayList<String> nameArray) {
        activity = a;
        name    =   nameArray;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {
        return name.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder{
        public TextView text;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        ViewHolder holder;
        if(convertView==null){
            vi = inflater.inflate(R.layout.list_item, null);
            holder=new ViewHolder();
            holder.text=(TextView)vi.findViewById(R.id.title);
            vi.setTag(holder);
        }
        else
            holder=(ViewHolder)vi.getTag();
        holder.text.setText(name.get(position));
        return vi;
    }
}