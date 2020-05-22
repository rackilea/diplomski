final Response.Listener<String> onPostsLoaded = new Response.Listener<String>() {
    @Override
    public void onResponse(String response) {
        dialog.dismiss();
        mainIcon.setVisibility(View.GONE);

        // Don't recreate the adapter, just update the data
        userList.clear();
        userList.addAll(Arrays.asList(gson.fromJson(response, User[].class)));
        recAdapter.notifyDataSetChanged();

        int num = recAdapter.goodCount;

        Snackbar.make(findViewById(android.R.id.content), String.valueOf(num), Snackbar.LENGTH_LONG)
                .show();
    }