@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View row = convertView;
    Cad_listHolder holder = null;


    if (row == null) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        holder = new Cad_listHolder();
        holder.txtTitle1 = (TextView)row.findViewById(R.id.cad_name);
        holder.txtTitle2 = (TextView)row.findViewById(R.id.maj_prog);
        holder.txtTitle3 = (TextView)row.findViewById(R.id.min_prog);
        holder.txtTitle4 = (TextView)row.findViewById(R.id.restrict);
        holder.txtTitle5 = (TextView)row.findViewById(R.id.strength);
        holder.txtTitle6 = (TextView)row.findViewById(R.id.feel);

        row.setTag(holder);

    }

    else {
        holder = (Cad_listHolder)row.getTag();
    }

    Cadence_list cadence_list = data[position];

    holder.txtTitle1.setVisibility(View.VISIBLE);
    holder.txtTitle2.setVisibility(View.VISIBLE);
    holder.txtTitle3.setVisibility(View.VISIBLE);
    holder.txtTitle4.setVisibility(View.VISIBLE);
    holder.txtTitle5.setVisibility(View.VISIBLE);
    holder.txtTitle6.setVisibility(View.VISIBLE);

    holder.txtTitle1.setText(Html.fromHtml(cadence_list.cad_name.replaceAll("6", "<sup>6</sup>")));
    holder.txtTitle2.setText(Html.fromHtml(cadence_list.maj_prog.replaceAll("6", "<sup>6</sup>")));
    holder.txtTitle3.setText(Html.fromHtml(cadence_list.min_prog.replaceAll("6", "<sup>6</sup>")));
    holder.txtTitle4.setText(Html.fromHtml(cadence_list.restrict.replaceAll("6", "<sup>6</sup>")));
    holder.txtTitle5.setText(Html.fromHtml(cadence_list.strength.replaceAll("6", "<sup>6</sup>")));
    holder.txtTitle6.setText(Html.fromHtml(cadence_list.feel.replaceAll("6", "<sup>6</sup>")));

    return row;

}