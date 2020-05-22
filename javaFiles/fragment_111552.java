public View getView(int position, View convertView, ViewGroup parent) {
            convertView = myInflater.inflate(R.layout.activity_template_shopping, null);
            drink_name = (TextView) convertView.findViewById(R.id.drink_name);
            size = (TextView) convertView.findViewById(R.id.size);
            sweet = (TextView) convertView.findViewById(R.id.sweet);
            feeding = (TextView) convertView.findViewById(R.id.feeding);
            count = (TextView) convertView.findViewById(R.id.count);
            price = (TextView) convertView.findViewById(R.id.price);
            ice = (TextView) convertView.findViewById(R.id.ice);

            if (drinkNamearry.size() == 0) {
                drink_name.setText("");
                size.setText("");
                sweet.setText("");
                ice.setText("");
            } else {
                drink_name.setText(drinkNamearry.get(position));
                size.setText(sizearry.get(position));
                sweet.setText(sweetarry.get(position));
                ice.setText(icearry.get(position));
            }
            return convertView;
        }