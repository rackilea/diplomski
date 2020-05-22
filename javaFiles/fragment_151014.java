@Override
public View getView(int position, View convertView, ViewGroup parent) {
if (convertView == null) {
    m = new ViewHolder();
    convertView = mInflater.inflate(R.layout.room_row, null);
    m.name = (TextView) convertView.findViewById(R.id.roomNameText);
    m.roomNumber = (TextView) convertView.findViewById(R.id.roomNumText);
    convertView.setTag(m);
} else {
    m = (ViewHolder) convertView.getTag();
}


m.name.setText(rooms.get(position).getName());
m.roomNumber.setText(String.valueOf(rooms.get(position).getRoomNumber()));
return convertView;

}