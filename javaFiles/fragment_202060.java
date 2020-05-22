Comparator<Post> comparator = new Comparator<Post>() {
    @Override
    public int compare(Post o1, Post o2) {
        return Long.compare(o1.timestamp, o2.timestamp);
    }
};