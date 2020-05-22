public class CustomAdapter extends ArrayAdapter<String> {

private LayoutInflater lf;

public CustomAdapter(Context context, String[] objects) {
    super(context, 0, objects);
    lf = LayoutInflater.from(context);
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder = null;
    if (convertView == null) {
        convertView = lf.inflate(R.layout.list_item, parent, false);
        holder = new ViewHolder();
        holder.btnLocalData = (Button) convertView
                .findViewById(R.id.btnLocalData);
        holder.btnOnlineData = (Button) convertView
                .findViewById(R.id.btnOnlineData);
        holder.tvItem = (TextView) convertView.findViewById(R.id.tvItem);
        holder.initListeners();
        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    holder.setData(getItem(position));

    return convertView;
}

public static class ViewHolder {
    TextView tvItem;
    Button btnOnlineData;
    Button btnLocalData;
    String mItem;

    public String getItem(){
        return mItem;
    }

    public void setData(String item) {
        mItem = item;
        tvItem.setText(item);
    }

    public void initListeners() {
        btnLocalData.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        "Local Data Clicked : " + mItem, Toast.LENGTH_LONG)
                        .show();
            }
        });
        btnOnlineData.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        "Online Data Clicked : " + mItem, Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

}

}