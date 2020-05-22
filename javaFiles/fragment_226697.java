private final Response.Listener<String> onPostsLoaded = new Response.Listener<String>() {

    @Override
    public void onResponse(String response) {
        msgs = Arrays.asList(gson.fromJson(response, Message[].class));
        System.out.println("inside " + msgs);
        MessageRVAdapter mAdapter = new MessageRVAdapter(msgs);//create an adapter
        recyclerView.setAdapter(mAdapter);  // set adapter
    }
};