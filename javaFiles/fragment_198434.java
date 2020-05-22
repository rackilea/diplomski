@Override
public View getView(final int position, View convertView, final ViewGroup parent) {
  ...

  if (position == 0)
    convertView.setBackground(R.id.first_row);
  else
    convertView.setBackground(R.id.any_other_row);

  ...
}