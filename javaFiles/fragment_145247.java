mYourListView..setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(context, "Item #" + position + " clicked", Toast.LENGTH_SHORT).show();

            // here, "position" is the position of your item and "id" is your
            // item's id in your data set.

            // mLastClickedPosition is a member field of type long which 
            // stores the position of the most recently clicked item, 
            // initially set to -1
            if(mLastClickedPosition != -1){
                  // do something to pause the item in your list at this position
            }

            // next, update mLastClickedPosition
            mLastClickedPosition = position

            // find the image in your view and update it
            if(position==0){
                  ImageView imageView = view.findViewById(R.id.your_image);
                  imageView.setImageResource(R.drawable.pause);
            }

            // play audio
            AudioListner.playRecord(position);

        }
    });