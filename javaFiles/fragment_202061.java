class Post implements Comparable<Post> {
    String PostId;
    Long timestamp = 0;

    @Override
    public int compareTo(@NonNull Post post) {
        return Long.compare(this.timestamp, post.timestamp);
    }
}