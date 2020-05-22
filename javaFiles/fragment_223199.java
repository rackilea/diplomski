query.findInBackground(new FindCallback<ParseUser>() {
                public void done(List<ParseUser> objects, ParseException e) {
                    if (e == null) {
                        // The query was successful.
                        if(objects.size() > 0){
                            ParseUser user = objects.get(0);
                            showProfileActivity(user);
                        }
                    } else {
                        // Something went wrong.
                    }
                }
            });