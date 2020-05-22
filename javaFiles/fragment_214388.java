holder = new ViewHolder();

holder.image = (ImageView) view.findViewById(R.id.photo);
holder.url = (TextView) view.findViewById(R.id.url);
holder.price = (TextView) view.findViewById(R.id.price);

view.setTag(holder);