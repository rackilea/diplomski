MappingManager manager = new MappingManager(session);

Mapper<Post> m = manager.mapper(Post.class);
...
// Retrieve posts with a projection query that only retrieves some of the fields
ResultSet rs = session.execute("select user_id, post_id, title from posts where user_id = " + u1.getUserId());

Result<Post> result = m.map(rs);
for (Post post : result) {
    assertThat(post.getUserId()).isEqualTo(u1.getUserId());
    assertThat(post.getPostId()).isNotNull();
    assertThat(post.getTitle()).isNotNull();

    assertThat(post.getDevice()).isNull();
    assertThat(post.getTags()).isNull();
}