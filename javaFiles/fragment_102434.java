private void retrieveYeets(Date date) {
        String groupId = ParseUser.getCurrentUser().getString("groupId");
        ParseQuery<ParseObject> query = new ParseQuery<>(ParseConstants.CLASS_YEET);
        query.whereContains(ParseConstants.KEY_GROUP_ID, groupId);
        query.orderByDescending("lastReplyUpdatedAt");
        if( date != null )
         query. whereGreaterThan("createdAt", date);
        query.setLimit(1000);
        query.findInBackground((yeets, e) -> {

            if (mSwipeRefreshLayout.isRefreshing()) {
                mSwipeRefreshLayout.setRefreshing(false);
            }

            if (e == null) {

                // We found messages!
                mYeets.addAll(0, yeets); //This should append new messages to the top
                /*System.out.println(yeets);*/
                if( mRecyclerView.getAdapter() == null ) {
                mAdapter = new FeedAdapter(getContext(), mYeets);
                mAdapter.setHasStableIds(true);
                mRecyclerView.setHasFixedSize(true);
                adapter.notifyDataSetChanged();
                mRecyclerView.setAdapter(adapter);
                }
                else {
                mAdapter.notifyDataSetChanged();
                }

            }
        });
    }