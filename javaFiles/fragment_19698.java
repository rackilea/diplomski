HypotheticalApi myApi = HypotheticalApi.getInstance();
        myApi.getUserProfile("techie.curious", new GetResponseCallback() {

            @Override
            void onDataReceived(Profile profile) {
                //Use the profile to display it on screen, etc.
            }

        });

        Profile newProfile = new Profile();
        myApi.postUserProfile(newProfile, new PostCallback() {

            @Override
            public void onPostSuccess() {
                //Display Success
            }
        });