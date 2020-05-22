@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View view = null;
    ViewHolder holder;
    if (convertView == null) {
        LayoutInflater inflater = this._context.getLayoutInflater();
        view = inflater.inflate(R.layout.contact_list_item, parent, false);
        holder = new ViewHolder();
        viewHolder.display_name = (TextView) view
                .findViewById(R.id.txtDisplayName);
        viewHolder.number = (TextView) view.findViewById(R.id.txtNumber);
        viewHolder.number_type = (TextView) view
                .findViewById(R.id.txtNumberType);            
        view.setTag(viewHolder);
    } else {
        view = convertView;
        holder = (ViewHolder) view.getTag();
    }        
    holder.setContact(_contacts.get(position));
    return view;
}