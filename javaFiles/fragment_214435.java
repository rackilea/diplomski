Bundle params = new Bundle();
        params.putString("fields", "email,birthday,picture.type(large)");

      new GraphRequest(AccessToken.getCurrentAccessToken(),  "/me/", params,      HttpMethod.GET,
                    new GraphRequest.Callback() {
                        public ImageLoader imageLoader;
                        public ImageView mImageView;
                        public UserInfo userModel;

                        @Override
                        public void onCompleted( GraphResponse response) {

                                saveDataInSingletone(response);
                                profileView.setInfoToView();

                        }

                        private void saveDataInSingletone(GraphResponse response)  {
                            JSONObject data = response.getJSONObject();
                            userModel = UserInfo.getInstance();
                            String lastName, firstName;
                            String profilePicUrl;


                            if (data.has("picture")) {
                                try {
                                    profilePicUrl = data.getJSONObject("picture").getJSONObject("data").getString("url");
                                   // getFacebookProfilePicture(profilePicUrl);

                                   // imageView = (ImageView) findViewById(R.id.pic);
                                   // imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                    userModel.setAvatar(profilePicUrl);
                                    //mImageView.setImageBitmap(profilePic);
                                   // userModel.setAvatar(profilePic);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                     try {
                            userModel.setEmail( data.getString("email"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            userModel.setEmail("");
                        }

                        try {
                            userModel.setBday(data.getString("birthday"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            userModel.setBday("");
                        }}).executeAsync();