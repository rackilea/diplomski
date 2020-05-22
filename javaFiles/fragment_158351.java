@Override
public void onResponse(JSONObject response) {
    String imageUrl = Query.shfaqFoton(response);
    if (imageUrl == ""){
        imageUrl = String.valueOf(R.drawable.news_photo1);
    }

    lajmi.setImage(imageUrl);
    // Add the notifyDataSetChanged here
    mAdapter.notifyDataSetChanged();
}