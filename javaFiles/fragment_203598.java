public void onPostSelected(int index) {
    PostData data = PostDataModel.getInstance().listData.get(index);
    Intent intent = new Intent(this, PostViewActivity.class);
    intent.putExtra("postLink", data.postLink);
    intent.putExtra("postTitle", data.postTitle);
    startActivity(intent);
}