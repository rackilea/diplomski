@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK){
        if(data.getClipData() != null){
            int totalItemsSelected = data.getClipData().getItemCount();
            linearLayout = (LinearLayout) findViewById(R.id.linear);
            for(int i = 0; i < totalItemsSelected; i++){
                Uri fileUri = data.getClipData().getItemAt(i).getUri();
                ImageView image = new ImageView(this);
                image.setAdjustViewBounds(true);
                image.setImageURI(fileUri);

                //click event
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.e(TAG,"Selected File URI : "+fileUri); 
                    }
                });

                linearLayout.addView(image);
            }
        }
    }
}