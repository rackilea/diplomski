@Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.menu_item, null);
                holder = new ViewHolder();

                holder.tvMenuHeader = (TextView) convertView.findViewById(R.id.tvMenuHeader);
                holder.ivMenu = (ImageView) convertView.findViewById(R.id.ivMenuItem); 
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            MyMenuItem row_pos = menuItems.get(position);

                Picasso.with(context)
                        .load(row_pos.getItem_image_url())
                        .placeholder(R.drawable.empty)
                        .error(R.drawable.error)
                        .into(holder.ivMenu);

                holder.tvMenuHeader.setText(row_pos.getItem_header());

                Log.e("Test", "headers:" + row_pos.getItem_header());
            return convertView;
        }