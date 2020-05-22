public View getView(final int position, View convertView, ViewGroup parent){
    final ViewHolder holder;

    holder.checkBox = (CheckBox) convertView.findViewById(R.id.cb);
    holder.contactName = (TextView) convertView.findViewById(R.id.contact_name);

    holder.contactName.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
        //Toast.makeText(context, contactList.get(position).getName() + " selected at " + position, Toast.LENGTH_SHORT).show();
        if (listener!=nul) {
           listener.openContactDetail(contactList.get(position).getName(), contactList.get(position).getNumber());
        }

    }
});