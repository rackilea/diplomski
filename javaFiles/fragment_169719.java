@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;

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

    holder.generalTV.setText(name);
    holder.generalCB.setChecked(farkle1);
    holder.generalCB2.setChecked(farkle2);
    holder.generalTV2.setText(score);

    return convertView;  // HERE!!
}