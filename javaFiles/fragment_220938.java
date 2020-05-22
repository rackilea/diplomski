query.fromLocalDatastore();
        query.whereEqualTo("objectId", id);
        query.getFirstInBackground(new GetCallback<ParseUser>() {
            @Override
            public void done(final ParseUser parseUser, ParseException e) {
                EventBus.getDefault().post(new AddFriendEvent(e == null, parseUser));
            }
        });