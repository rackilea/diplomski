@Override
    public void onResponse(JSONArray response) {
        if(response == null )
            return;
        postDataList.clear();
        parseJsonResponse(response);
        //==========setting adapter to the recyclerview  <==
        allContentRecyclerView.setAdapter(new PostRecyclerAdapter(getActivity() ,postDataList));
    }