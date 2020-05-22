if(imgURLs.size()>0){              
    try{


                        setImage(imgURLs.get(0), galleryImage, mAppend);



                    mSelectedImage = imgURLs.get(0);
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Log.d(TAG, "onItemClick: selected an image: " + imgURLs.get(position));

                            setImage(imgURLs.get(position), galleryImage, mAppend);
                            mSelectedImage = imgURLs.get(position);
                        }
                    });

             catch (Exception EX){
            }
    }
else{
//No image url
}