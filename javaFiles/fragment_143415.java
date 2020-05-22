@Override
public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
        LayoutInflater vi =
            (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = vi.inflate(R.layout.itemplayer, null);
    }
    final Player custom = entries.get(position);
    if (custom != null)
        ((TextView) convertView.findViewById(R.id.nomecharlist)).setText(custom.getNomePlayer());
    return convertView;
}