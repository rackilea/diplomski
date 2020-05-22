public View getView(final int position, View convertView, ViewGroup parent){

    // your other stuff here

    convertView.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            Person p = getItem(position);

            personDatabaseHelper.deleteItem(p.getId());  
            remove(p);

            notifyDataSetChanged(); 
            return true;
        }
    });

    return convertView;
}