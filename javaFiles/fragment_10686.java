holder.txt = (EditText) convertView.findViewById(R.id.txt);

    holder.buttonLine = (Button) convertView
            .findViewById(R.id.buttonLine);

    holder.buttonLine.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            Toast.makeText(context,
                    "Delete-" + v.getTag().toString(),
                    Toast.LENGTH_SHORT).show();
        }
    });

    convertView.setTag(holder);
} else {
    // Get the ViewHolder back to get fast access to the TextView
    // and the ImageView.
    holder = (ViewHolder) convertView.getTag();
}
holder.buttonLine.setTag(position);
//rest of the method
return convertView;