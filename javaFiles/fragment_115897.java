public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
    //first get the elements by doing like
    TextView note = (TextView)view.findViewById(R.id.listViewNote);
    ImageView img = (ImageView) view.findViewById(R.id.listViewImg);
    ImageButton likeButton = (ImageButton) convertView.findViewById(R.id.heartImage);

    likeButton.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            likeButton.setBackgroundResource(R.id.icon);
        }
    });
}