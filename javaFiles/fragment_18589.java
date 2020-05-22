@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    View row = convertView;
    final Holder holder;
    if (row == null) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);
... 
if(position==thePositionYouNeed)
row.setBackgroundColor(color)