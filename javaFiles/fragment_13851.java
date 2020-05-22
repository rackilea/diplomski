public class PeopleListAdapter extends BaseAdapter {

private Context context;
private ArrayList<People> peopleItems;

public PeopleListAdapter(Context context,
        ArrayList<People> peopleItems) {
    this.context = context;
    this.peopleItems = peopleItems;
}

@Override
public int getCount() {
    return peopleItems.size();
}

@Override
public Object getItem(int position) {
    return peopleItems.get(position);
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(R.layout.people_list_item, null);
    }
    // TODO
    /**
     * Return some list row..
     */
    TextView nameTxt = (TextView) convertView.findViewById(R.id.name);
    TextView phoneTxt = (TextView) convertView.findViewById(R.id.phone);
    TextView addressTxt = (TextView) convertView.findViewById(R.id.address);

    nameTxt.setText(peopleItems.get(position).getName());
    phoneTxt.setText(peopleItems.get(position).getPhone());
    phoneTxt.setText(peopleItems.get(position).getAddress());

    return convertView;
}

}