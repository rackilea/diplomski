public void addMenu(List<Category> posts) {
    categoryAdapter.addAllData(posts);
    categoryAdapter.notifyDataSetChanged();
}

public void addAllData(List<Categories> posts) {
    this.posts.clear();
    this.posts.addAll(posts);
}