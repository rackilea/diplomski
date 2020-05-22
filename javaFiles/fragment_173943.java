public void setImage(final Context c,final String imageUrl){

            try {
                if (imageUrl!=null) {
                    //

                    Picasso.with(c).load(imageUrl).error(R.mipmap.add_btn).fit().centerInside().placeholder(R.mipmap.add_btn)
                            .networkPolicy(NetworkPolicy.OFFLINE).into(imagePost, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {

                            //Reloading an image again ...
                            Picasso.with(c).load(imageUrl).error(R.mipmap.add_btn).placeholder(R.mipmap.add_btn)
                                    .into(imagePost);
                        }
                    });





                } else {

                    imagePost.setVisibility(View.GONE);
                }
            }
            catch (Exception e){

            }

        }

        public void setVideo(final Context c, final String videoUrl){
            try {
                if (videoUrl!=null) {
                    try {
                        Uri videoUri = Uri.parse(videoUrl);
                        try {
                            videoLayout.setVideoURI(videoUri);
                            videoLayout.setTag(videoUrl);
                            String hasVideo_string = (String) videoLayout.getTag();
                            boolean hasVideo = Boolean.parseBoolean(hasVideo_string);


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        System.out.println("Error :" + e);
                    }

                } else {
                    videoLayout.setVisibility(View.GONE);
                }
            }
            catch (Exception e){

            }


        }