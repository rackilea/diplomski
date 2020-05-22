public class GeneralAdapter extends BaseAdapter {

private static final CharSequence Name = null;
private LayoutInflater mInflater = null;
private ArrayList<DataItem> info = null;

public GeneralAdapter( ArrayList<DataItem> info) {
    this.info = info;
}

@Override
public int getCount() {
    return info.size();
}

@Override
public Object getItem(int position) {
    return info.get(position);
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    DataItem dataItem = getItem(position);

    if (convertView == null) {
        convertView = mInflater.inflate(R.layout.row, null);

        holder = new ViewHolder();
        holder.generalTV = (TextView) convertView.findViewById(R.id.tvPlayer);
        holder.generalCB = (CheckBox) convertView.findViewById(R.id.cbFarkle1);
        holder.generalCB2 = (CheckBox) convertView.findViewById(R.id.cbFarkle2);
        holder.generalTV2 = (TextView) convertView.findViewById(R.id.tvScore);

        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    holder.generalTV.setText(dataItem.name);
    holder.generalCB.setChecked(dataItem.farkle1);
    holder.generalCB2.setChecked(dataItem.farkle2);
    holder.generalTV2.setText(dataItem.score);

    return convertView;
}

private class ViewHolder {
    TextView generalTV;
    TextView generalTV2;
    CheckBox generalCB;
    CheckBox generalCB2;
}
}