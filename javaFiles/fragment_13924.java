View vi = convertView;
        ViewHolder holder;

        if (convertView == null) {

            vi = inflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.merchant_type  = (TextView) vi.findViewById(R.id.merchant_type);
            holder.merchant_name  = (TextView) vi.findViewById(R.id.merchant_name);
            holder.merchant_location  = (TextView) vi.findViewById(R.id.merchant_location);

            vi.setTag(holder);

        } else
            holder = (ViewHolder) vi.getTag();

        // now set your text view here like 

          holder.merchant_name.setText("Bla Bla Bla");


        // return your view
        return vi;