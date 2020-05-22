public class AdapterElement extends BaseAdapter {
private List<String> one;
private List<String> two;
private List<String> three;

LayoutInflater mInflater;

public AdapterElement(Context context, List<String> SSID, List<String> BSSID, List<String> Level){

    one = SSID;
    two = BSSID;
    three = Level;

    mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

}

@Override
public int getCount() {
    return one.size();
}

@Override
public Object getItem(int position) {
    return one.get(position);
}

@Override
public long getItemId(int position) {
    return position;
}

public View getView(int position, View view, ViewGroup parent){

    View v = mInflater.inflate(R.layout.items,null);

    TextView tvSSID = (TextView) v.findViewById(R.id.tvSSID);
    tvSSID.setText(one.get(position));

    TextView tvSecurity = (TextView) v.findViewById(R.id.tvSecurity);
    tvSecurity.setText(two.get(position));

    TextView tvLevel = (TextView) v.findViewById(R.id.tvLevel);
    tvLevel.setText(three.get(position));

    return v;

}