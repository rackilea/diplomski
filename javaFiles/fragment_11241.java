public class HP_ListAdapter  extends BaseAdapter {
    public ArrayList<HPEntity> countries = new ArrayList<HPEntity>();
    Context mContext;

    public HP_ListAdapter(Context mContext, ArrayList<HPEntity> countries) {
        this.mContext = mContext;
        this.countries = countries;
    }

    @Override
    public int getCount() {
        return  countries.size();
    }

    @Override
    public Object getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolderItem {
        TextView name;
        TextView code;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolderItem holder = new ViewHolderItem();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.homepage_item, null);

            holder.name = (TextView) convertView.findViewById(R.id.busID);
            holder.code = (TextView) convertView.findViewById(R.id.busNAME);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolderItem) convertView.getTag();
        }

        holder.name.setText(this.countries.get(position).name);
        holder.code.setText(this.countries.get(position).code);

        return convertView;
    }
}