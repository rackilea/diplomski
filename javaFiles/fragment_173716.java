if (convertView == null) {
        convertView = inflater.inflate(/**layout file**/, parent, false);
        viewHolder = new ViewHolder();
        viewHolder.content = (TextView) view.findViewById(R.id.list_layout);

        viewHolder.content.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                convertView.setBackgroundColor(Color.YELLOW);
        });
        vi.setTag(viewHolder);
    } else {
        // else code goes here
        viewHolder = (ViewHolder) convertView.getTag();  
    }