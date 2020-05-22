if (convertView == null) {
    convertView = LayoutInflater.from(context).inflate(
                      R.layout.your_layout, parent, false);
}

lLayout = (LinearLayout) convertView.findViewById(R.id.imageLinearLayout);