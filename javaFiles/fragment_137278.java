getActivity().runOnUiThread(new Runnable() {
           public void run() {
               listAdapter = new FeedListAdapter(getActivity(), feedItems);
               feed.setAdapter(listAdapter);
               listAdapter.notifyDataSetChanged();
           }
 }