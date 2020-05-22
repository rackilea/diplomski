Button buttonDelete = (Button) convertView.findViewById(R.id.buttonDelete);
buttonDelete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        objectsList.remove(position);
        notifyDataSetChanged();
    }
});