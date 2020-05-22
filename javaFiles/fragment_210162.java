mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            if (mLayoutManager.findLastCompletelyVisibleItemPosition() ==
                    mObjectList.size() - 1 && !mIsLoading && !mIsEnded) {
                mIsLoading = true;
                getList();
            }
        }
    });


private void getList() {
    addProgressItem();
    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
            mUrl, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            mRefreshLayout.setRefreshing(false);
            removeProgressItem();
            setLoading(); // isLoading = false
            handleListResponse(response);
            isEmptyList();
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            mRefreshLayout.setRefreshing(false);
            removeProgressItem();
            setLoading();
            VolleyErrorHandler.handle(MainActivity.this, error);
            isEmptyList();
        }
    });

    AppController.getInstance().addToRequestQueue(jsonObjectRequest, "list");
}

private void handleListResponse(JSONObject response) {
    clearList();

    try {
        mCount = response.getInt("count");
        mNextUrl = response.getString("next_url");

        //process JSON here

        mAdapter.notifyDataSetChanged();

        if (mNextUrl == null || TextUtils.isEmpty(mNextUrl) || mNextUrl.equals("null")) {
            isEnded();//set list ended
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }
}

private void addProgressItem() {
    if (mCount != 0) {
        mObjectList.add(null);
        mAdapter.notifyItemInserted(mObjectList.size() - 1);
    }
}

private void removeProgressItem() {
    if (mCount != 0) {
        mObjectList.remove(mObjectList.size() - 1);
        mAdapter.notifyItemRemoved(mObjectList.size());
    }
}

private void setLoading() {
    mIsLoading = false;
}

private void isEnded() {
    mIsEnded = true;
}

private void isEmptyList() {
    if (mObjectList.size() == 1) {
        mObjectList.add(1, -1);
        mAdapter.notifyItemInserted(1);
    } else if (mObjectList.get(1) instanceof Integer) {
        mObjectList.remove(1);
        mAdapter.notifyItemRemoved(1);
    }
}