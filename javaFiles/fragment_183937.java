Context context;
List<Map<String, Object>> data;
public SimpleListViewAdaptor(Context context, List<Map<String, Object>> data) {
    super();
    this.context=context;
    this.data=data;

}

@Override
public Map<String,Object> getItem(int position) {
    return data.get(position);
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public int getCount() {
    return data.size();
}

@Override
public View getView(final int position, View convertView, ViewGroup parent) {
      HolderView holderView;
    if (convertView == null) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(R.layout.customr_item_list,parent, false);
        holderView = new HolderView();
        holderView.aSwitch = (Switch) convertView.findViewById(R.id.togglebtn);
        convertView.setTag(holderView);
    } else {
        // View recycled !
        // no need to inflate
        // no need to findViews by id
        holderView = (HolderView) convertView.getTag();
    }

        holderView.aSwitch.setChecked((Boolean)data.get(position).get("Status"));
    holderView.aSwitch.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            if(((Switch)v).isChecked()){
                ((Switch)v).setChecked(true);
                data.get(position).put("Status",true);//this is imp to update the value in dataset which is provided to listview

            }else{
                ((Switch)v).setChecked(false);
                data.get(position).put("Status",false);

            }
        }
    });
    return convertView;
}

static class HolderView{
    Switch aSwitch;
}