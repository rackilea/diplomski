Picasso.with(getApplicationContext()).load(headerUserObject.getParseFile("profilePicture").getUrl())
            .placeholder(R.color.placeholderblue).networkPolicy(NetworkPolicy.OFFLINE) // try to load the image from cache first
            .into(((ImageView) findViewById(R.id.profile_picture)), new Callback() {
                        @Override
                        public void onSuccess() {
                            //cache file for this url exists, now update the cache for this url
                            if(networkAvaialable()) // if internet is working update the cache file
                                Picasso.with(getApplicationContext()).invalidate(headerUserObject.getParseFile("profilePicture").getUrl());
                        }

                        @Override
                        public void onError() { // if cache file does not exist load it from the internet
                            Picasso.with(getApplicationContext()).load(headerUserObject.getParseFile("profilePicture").getUrl())
                            .placeholder(R.color.placeholderblue)
                            .into(((ImageView) findViewById(R.id.profile_picture)));
                        }
                    });