userTimeline.next(null, new Callback<TimelineResult<Tweet>>() {
        @Override
        public void success(Result<TimelineResult<Tweet>> result) {

        }

        @Override
        public void failure(TwitterException exception) {
            Log.d("TAG",exception.getMessage());
        }
    });